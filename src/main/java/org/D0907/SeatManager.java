package org.D0907;

import java.util.PriorityQueue;
/*
Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.


Example 1:
Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]

Explanation
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].


Constraints:

1 <= n <= 105
1 <= seatNumber <= n
For each call to reserve, it is guaranteed that there will be at least one unreserved seat.
For each call to unreserve, it is guaranteed that seatNumber will be reserved.
At most 105 calls in total will be made to reserve and unreserve.
 */

/*
Approach
The approach we've taken is a combination of a Counter and Min-Heap strategy.

Counter (last): This keeps track of the latest continuous seat that's been reserved.
For example, if seats 1, 2, and 3 are reserved and no unreservations have been made, last will be 3.

Min-Heap (pq): This is used to keep track of seats that have been unreserved and are out of the continuous sequence.
For instance, if someone reserves seats 1, 2, and 3, and then unreserves seat 2, then seat 2 will be added to the min-heap.

The logic for the reserve and unreserve functions is as follows:

reserve:
If the min-heap is empty, simply increment the last counter and return it.
If the min-heap has seats (i.e., there are unreserved seats), pop the smallest seat from the heap and return it.

unreserve:
If the seat being unreserved is the last seat in the continuous sequence, decrement the last counter.
Otherwise, add the unreserved seat to the min-heap.
Complexity

Time complexity:
reserve: Average O(1) (when using the counter), but O(logn) (when using the min-heap).
unreserve: O(logn) (due to the min-heap operation).

Space complexity: O(n). This is the worst-case scenario where all seats have been reserved and then unreserved, filling up the min-heap.
 */
public class SeatManager {

    private int last;
    private PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        this.last = 0;
        this.pq = new PriorityQueue<>();
    }

    public int reserve() {
        if (pq.isEmpty()) {
            return ++last;
        } else {
            return pq.poll();
        }
    }

    public void unreserve(int seatNumber) {
        if (seatNumber == last) {
            --last;
        } else {
            pq.offer(seatNumber);
        }
    }


    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }
}
