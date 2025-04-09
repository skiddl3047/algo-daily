package amazon.lld.parkinglot;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLotFinal {
}

// Enums for type safety
enum ParkingSpotType {
    HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
}

enum VehicleType {
    MOTORBIKE, CAR, TRUCK, VAN, ELECTRIC
}

enum TicketStatus {
    PAID, UNPAID, LOST
}

// 1. Abstraction: Vehicle class encapsulates common vehicle properties
class Vehicle {
    private final String plateNumber;
    private final VehicleType type;

    public Vehicle(String plateNumber, VehicleType type) {
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public VehicleType getType() { return type; }
    public String getPlateNumber() { return plateNumber; }
}

// 2. Encapsulation: ParkingSlot hides internal state
class ParkingSlot {
    private final String slotNumber;
    private final ParkingSpotType type;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSlot(String slotNumber, ParkingSpotType type) {
        this.slotNumber = slotNumber;
        this.type = type;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (!isOccupied && isVehicleCompatible(vehicle.getType())) {
            this.vehicle = vehicle;
            isOccupied = true;
            return true;
        }
        return false;
    }

    // Updated vehicle compatibility check
    private boolean isVehicleCompatible(VehicleType vehicleType) {
        return switch (type) {
            case HANDICAPPED -> true;
            case COMPACT -> vehicleType == VehicleType.CAR || vehicleType == VehicleType.ELECTRIC;
            case LARGE -> vehicleType == VehicleType.CAR || vehicleType == VehicleType.TRUCK ||
                    vehicleType == VehicleType.VAN || vehicleType == VehicleType.ELECTRIC;
            case MOTORBIKE -> vehicleType == VehicleType.MOTORBIKE;
            case ELECTRIC -> vehicleType == VehicleType.ELECTRIC;
        };
    }


    public Vehicle removeVehicle() {
        Vehicle removed = vehicle;
        vehicle = null;
        isOccupied = false;
        return removed;
    }
    // Getters
    public String getSlotNumber() { return slotNumber; }
    public ParkingSpotType getType() { return type; }
    public boolean isOccupied() { return isOccupied; }
}

// 3. Composition: Ticket is composed with ParkingSlot
class Ticket {
    private final String ticketId;
    private final ParkingSlot slot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
    private double charge;

    public Ticket(String ticketId, ParkingSlot slot) {
        this.ticketId = ticketId;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.UNPAID;
    }

    public void calculateCharge() {
        long hours = java.time.Duration.between(entryTime, LocalDateTime.now()).toHours();
        this.charge = hours * getRatePerHour();
    }

    private double getRatePerHour() {
        return switch (slot.getType()) {
            case HANDICAPPED -> 2.0;
            case COMPACT -> 3.0;
            case LARGE -> 5.0;
            case MOTORBIKE -> 1.0;
            case ELECTRIC -> 2.5;
        };
    }

    // Getters/Setters
    public void markPaid() { status = TicketStatus.PAID; }
    public TicketStatus getStatus() { return status; }
    public double getCharge() { return charge; }

    public ParkingSlot getSlot() {
        return slot;
    }

    public String getTicketId() {
        return ticketId;
    }
}

// 4. Aggregation: ParkingLot manages composition of slots and tickets
class ParkingLot {
    private final Map<ParkingSpotType, List<ParkingSlot>> slots;
    private final Map<String, Ticket> activeTickets;
    private final Map<String, ParkingSlot> vehicleParking;

    public ParkingLot() {
        slots = new EnumMap<>(ParkingSpotType.class);
        activeTickets = new HashMap<>();
        vehicleParking = new HashMap<>();
        initializeSlots();
    }

    private void initializeSlots() {
        Arrays.stream(ParkingSpotType.values()).forEach(type ->
                slots.put(type, new ArrayList<>()));
    }

    public void addParkingSlot(ParkingSpotType type, String slotNumber) {
        slots.get(type).add(new ParkingSlot(slotNumber, type));
    }

    // 5. Polymorphism: Different parking strategies
    public Ticket parkVehicle(Vehicle vehicle) {
        List<ParkingSpotType> preferredTypes = getPreferredSpotTypes(vehicle.getType());

        synchronized (this) {
            for (ParkingSpotType type : preferredTypes) {
                Optional<ParkingSlot> slot = slots.get(type).stream()
                        .filter(s -> !s.isOccupied())
                        .findFirst();

                if (slot.isPresent()) {
                    ParkingSlot assignedSlot = slot.get();
                    if (assignedSlot.assignVehicle(vehicle)) {
                        // ... existing ticket creation code ...
                        return new Ticket(UUID.randomUUID().toString(),assignedSlot);
                    }
                }
            }
            throw new IllegalStateException("No available slots for vehicle type: " + vehicle.getType());
        }
    }

    private List<ParkingSpotType> getPreferredSpotTypes(VehicleType vehicleType) {
        return switch (vehicleType) {
            case MOTORBIKE -> List.of(ParkingSpotType.MOTORBIKE);
            case CAR -> List.of(ParkingSpotType.COMPACT, ParkingSpotType.LARGE);
            case TRUCK, VAN -> List.of(ParkingSpotType.LARGE);
            case ELECTRIC -> List.of(ParkingSpotType.ELECTRIC, ParkingSpotType.COMPACT, ParkingSpotType.LARGE);
        };
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) throw new IllegalArgumentException("Invalid ticket ID");

        synchronized (this) {
            ticket.calculateCharge();
            ticket.markPaid();
            ParkingSlot slot = ticket.getSlot();
            Vehicle vehicle = slot.removeVehicle();
            vehicleParking.remove(vehicle.getPlateNumber());
            return ticket.getCharge();
        }
    }
}
