package amazon.lld.amazonlocker;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AmazonLocker {
}

enum LockerSize {
    SMALL(10, 10, 12),   // Width, Depth, Height in inches
    MEDIUM(12, 12, 18),
    LARGE(18, 18, 24);

    private final int width;
    private final int depth;
    private final int height;

    LockerSize(int width, int depth, int height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public boolean canFit(Package pkg) {
        return pkg.getWidth() <= width &&
                pkg.getDepth() <= depth &&
                pkg.getHeight() <= height;
    }
}

enum LockerStatus {
    AVAILABLE, OCCUPIED, MAINTENANCE
}

class Locker {
    private final String lockerId;
    private final LockerSize size;
    private LockerStatus status;
    private String packageId;
    private LocalDateTime expiration;
    private String accessCode;

    public Locker(String lockerId, LockerSize size) {
        this.lockerId = lockerId;
        this.size = size;
        this.status = LockerStatus.AVAILABLE;
    }

    public synchronized boolean assignPackage(Package pkg, String code) {
        if (status == LockerStatus.AVAILABLE && size.canFit(pkg)) {
            this.packageId = pkg.getPackageId();
            this.accessCode = code;
            this.expiration = LocalDateTime.now().plusHours(72);
            this.status = LockerStatus.OCCUPIED;
            return true;
        }
        return false;
    }

    public synchronized boolean releasePackage(String code) {
        if (status == LockerStatus.OCCUPIED && accessCode.equals(code)) {
            reset();
            return true;
        }
        return false;
    }

    private void reset() {
        packageId = null;
        accessCode = null;
        expiration = null;
        status = LockerStatus.AVAILABLE;
    }

    // Getters
    public String getLockerId() { return lockerId; }
    public LockerSize getSize() { return size; }
    public LockerStatus getStatus() { return status; }

    public LocalDateTime getExpiration() {
        return expiration;
    }
}

class LockerLocation {
    private final String locationId;
    private final double latitude;
    private final double longitude;
    private final Map<LockerSize, List<Locker>> lockers;

    public LockerLocation(String locationId, double lat, double lon) {
        this.locationId = locationId;
        this.latitude = lat;
        this.longitude = lon;
        this.lockers = new EnumMap<>(LockerSize.class);
    }

    public void addLocker(Locker locker) {
        lockers.computeIfAbsent(locker.getSize(), k -> new ArrayList<>()).add(locker);
    }

    public Optional<Locker> findAvailableLocker(Package pkg) {
        return lockers.entrySet().stream()
                .filter(e -> e.getKey().canFit(pkg))
                .flatMap(e -> e.getValue().stream())
                .filter(l -> l.getStatus() == LockerStatus.AVAILABLE)
                .findFirst();
    }

    public String getLocationId() {
        return locationId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

class Package {
    private final String packageId;
    private final int width;
    private final int depth;
    private final int height;

    public Package(String packageId, int w, int d, int h) {
        this.packageId = packageId;
        this.width = w;
        this.depth = d;
        this.height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public String getPackageId() {
        return packageId;
    }

    // Getters
}

class LockerService {
    private static LockerService instance;
    private final Map<String, LockerLocation> locations;
    private final ScheduledExecutorService scheduler;
    private final Map<String, Locker> activeDeliveries;

    private LockerService() {
        this.locations = new ConcurrentHashMap<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.activeDeliveries = new ConcurrentHashMap<>();
        startExpirationChecker();
    }

    public static synchronized LockerService getInstance() {
        if (instance == null) {
            instance = new LockerService();
        }
        return instance;
    }

    public Optional<String> assignLocker(Package pkg, double userLat, double userLon) {
        LockerLocation nearest = findNearestLocation(userLat, userLon);
        return nearest.findAvailableLocker(pkg)
                .map(locker -> {
                    String code = generateAccessCode();
                    if (locker.assignPackage(pkg, code)) {
                        activeDeliveries.put(pkg.getPackageId(), locker);
                        return code;
                    }
                    return null;
                });
    }

    public boolean pickupPackage(String packageId, String code) {
        return Optional.ofNullable(activeDeliveries.get(packageId))
                .map(locker -> locker.releasePackage(code))
                .orElse(false);
    }

    private LockerLocation findNearestLocation(double userLat, double userLon) {
        // Implement geospatial search logic
        return locations.values().iterator().next(); // Simplified
    }

    private String generateAccessCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private void startExpirationChecker() {
        scheduler.scheduleAtFixedRate(() ->
                activeDeliveries.values().removeIf(locker ->
                        locker.getStatus() == LockerStatus.OCCUPIED &&
                                locker.getExpiration().isBefore(LocalDateTime.now())
                ), 1, 1, TimeUnit.HOURS);
    }
}