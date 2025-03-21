package org.E1221;

/*
Story Points Problem

Given an array of story points for tasks, determine the minimum value of X (daily capacity)
required to complete all tasks in Y days.
Follow-up: What if X is a floating-point value?
Thoughts: The interviewer kept asking me to find a bug in my code but later provided a test case where my solution worked correctly 😐.
Felt more like a test than a discussion.

 */
public class MinDailyCapacity {

    public static int minDailyCapacity(int[] tasks, int Y) {
        int low = 0, high = 0;
        for (int task : tasks) {
            high += task;
            low = Math.max(task,low);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(tasks, Y, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isFeasible(int[] tasks, int Y, int X) {
        int days = 1;
        int currentSum = 0;
        for (int task : tasks) {
            if (currentSum + task > X) {
                days++;
                currentSum = task;
                if (days > Y) return false;
            } else {
                currentSum += task;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] tasks = {3, 2, 2, 4, 1, 4};
        System.out.println("Minimum daily capacity: " + minDailyCapacity(tasks, 3));
    }
}
