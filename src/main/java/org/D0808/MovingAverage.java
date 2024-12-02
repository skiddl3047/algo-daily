package org.D0808;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.


Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3


Constraints:

1 <= size <= 1000
-105 <= val <= 105
At most 104 calls will be made to next.
 */
public class MovingAverage {
    private final int [] window;
    private int curTotal, insertPos = 0;
    private long sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
    }

    /*
    Time Complexity: O(1), as we can see that there is no loop in the next(val) function.
    Space Complexity: O(N), where N is the size of the circular queue.
     */
    public double next(int value) {
        if(curTotal < window.length)
            curTotal++;
        //insertPos is where you're going to insert the new number and trying to remove if it has already existing number
        sum = sum - window[insertPos];
        sum = sum + value;

        window[insertPos] = value;
        insertPos = (insertPos + 1) % window.length;

        return (double) sum/curTotal;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));


    }
}
