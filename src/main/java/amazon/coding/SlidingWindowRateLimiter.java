package amazon.coding;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter {
    private final int maxRequests;
    private final long windowMillis;
    private final ConcurrentHashMap<CompositeKey, Deque<Long>> requests;

    public SlidingWindowRateLimiter(int maxRequests, Duration window) {
        this.maxRequests = maxRequests;
        this.windowMillis = window.toMillis();
        this.requests = new ConcurrentHashMap<>();
    }

    public synchronized boolean allowRequest(String userId, String ipAddress) {
        CompositeKey key = new CompositeKey(userId, ipAddress);
        long now = System.currentTimeMillis();
        Deque<Long> timestamps = requests.computeIfAbsent(key, k -> new ArrayDeque<>());

        // Remove outdated timestamps
        while (!timestamps.isEmpty() && now - timestamps.peekFirst() > windowMillis) {
            timestamps.removeFirst();
        }

        if (timestamps.size() < maxRequests) {
            timestamps.addLast(now);
            return true;
        }
        return false;
    }

    private static class CompositeKey {
        private final String userId;
        private final String ipAddress;

        public CompositeKey(String userId, String ipAddress) {
            this.userId = userId;
            this.ipAddress = ipAddress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompositeKey that = (CompositeKey) o;
            return userId.equals(that.userId) && ipAddress.equals(that.ipAddress);
        }

        @Override
        public int hashCode() {
            int result = userId.hashCode();
            result = 31 * result + ipAddress.hashCode();
            return result;
        }
    }

    // Usage example
    public static void main(String[] args) {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(6, Duration.ofSeconds(1));

        // Simulate requests
        System.out.println(limiter.allowRequest("user1", "192.168.1.1"));  // true
        System.out.println(limiter.allowRequest("user1", "192.168.1.1"));  // true
        System.out.println(limiter.allowRequest("user1", "192.168.1.1"));  // true
        System.out.println(limiter.allowRequest("user1", "192.168.1.1"));  // true
        System.out.println(limiter.allowRequest("user1", "192.168.1.1"));  // true
        System.out.println(limiter.allowRequest("user1", "192.168.1.1"));  // false

        SlidingWindowRateLimiter limiter1 = new SlidingWindowRateLimiter(10, Duration.ofSeconds(1));
        int i=0;
        while(true) {
// Check if request is allowed
            if (limiter1.allowRequest("user123", "192.168.1.1")) {
                // Process request
                System.out.println("Request Processed - "+i);
            } else {
                // Rate limit exceeded
                //System.out.println("Rate Limit Exceeded - "+i);
            }
            i++;
        }
    }
}
