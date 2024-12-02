package org.D0807;

import java.util.Arrays;

public class MaxAdditionalDinersCount {

    public static void main(String[] args) {
        System.out.println(getMaxAdditionalDinersCount(10,1,2, new int[] {2,6}));
    }
    //N - Total
    // K - gap betwen seats
    // M - current diners count
    // S - arrays of seats
    public static long getMaxAdditionalDinersCount(long totalSeats, long gapBetweenSeats, int currentDinersCount, int[] currentSeatingArray) {
        // Write your code here
        long minSeats = gapBetweenSeats + 1;
        if (currentDinersCount == 0) {
            return totalSeats / minSeats + 1;
        }

        Arrays.sort(currentSeatingArray);
        long result = 0L;

        long firstChair = currentSeatingArray[0];
        long firstAvailableIndex = (firstChair - 1) - minSeats;
        if (firstAvailableIndex >= 0) {
            result += firstAvailableIndex / minSeats + 1;
        }

        for (int index = 0; index < currentDinersCount - 1; index++) {

            long leftFreeChair = currentSeatingArray[index] + minSeats;
            long rightFreeChair = currentSeatingArray[index + 1] - minSeats;
            long diffSpace = rightFreeChair - leftFreeChair;
            if (diffSpace >= 0) {
                result += diffSpace / minSeats + 1;
            }
        }

        long lastChair = currentSeatingArray[currentDinersCount - 1];
        long lastAvailableIndex = (lastChair - 1) + minSeats;
        if (lastAvailableIndex <= totalSeats-1) {
            result += (totalSeats - 1 - lastAvailableIndex)/ minSeats + 1;
        }
        return result;
    }
}
