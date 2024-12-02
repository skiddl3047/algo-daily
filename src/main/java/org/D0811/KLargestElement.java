package org.D0811;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num: nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        // this array will store the occurrences of the element at respective position
        // ex : if count[4] = 1 => 4 has occurred once in the list
        // The range of possible values in nums goes from minValue (smallest number) to maxValue (largest number).
        // The number of possible unique values between minValue and maxValue is maxValue - minValue + 1.
        //For example, if minValue is 3 and maxValue is 8, the range includes 3, 4, 5, 6, 7, 8, which gives 8 - 3 + 1 = 6 possible values.
        // Thus, we need an array of size 6 to hold counts for each number in this range.
        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            /* Here, num - minValue is used as the index in the count array.
              This transformation shifts the range so that minValue maps to index 0, minValue + 1 maps to index 1, and so on up to maxValue,
              which maps to the last index of the array.
            As we iterate over each num in nums, count[num - minValue]++ increments the count at that position.
            This effectively tracks the frequency of each value in the array.*/
            count[num - minValue]++;
        }
        //System.out.println(Arrays.toString(count));
        int remain = k;
        for (int num = count.length - 1; num >= 0; num--) {
            System.out.println("remain = remain-"+remain+" count[num] "+count[num]);
            remain -= count[num];
            if (remain <= 0) {
                return num + minValue;
            }
        System.out.println(Arrays.toString(count));
        }

        return -1;
    }

    public int findKthLargestUsingPriorityQueue(int[] nums, int k) {
        // To append the elements in decreasing order in the queue Rather than default, which arranges in increasing order we
        //added Collections.reverseOrder() to arrange in decreasing way
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: nums){
            priorityQueue.add(n);
        }
        // Popping out i.e removing out the numbers upto k
        for(int i=1;i<k;i++){
            priorityQueue.poll();
        }
        // Return the top most element present at the queue
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new KLargestElement().findKthLargest(new int[]{1,2,3,10,10,10}, 4));//
        System.out.println(new KLargestElement().findKthLargest(new int[]{1,2,3,4,4,4}, 2));//

        System.out.println(new KLargestElement().findKthLargest(new int[]{3,2,6,4}, 1));//

        System.out.println(new KLargestElement().findKthLargest(new int[]{3,2,1,5,6,4}, 2));//
        System.out.println(new KLargestElement().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        System.out.println(new KLargestElement().findKthLargest(new int[]{-3,-2,-1,-4,-5,-6}, 5));
        System.out.println(new KLargestElement().findKthLargest(new int[]{300,200,100,500,600}, 3));
    }
}
/*
Complexity Analysis

Given n as the length of nums and m as maxValue - minValue,
Time complexity: O(n+m)

We first find maxValue and minValue, which costs O(n).
Next, we initialize count, which costs O(m).
Next, we populate count, which costs O(n).

Finally, we iterate over the indices of count, which costs up to O(m).

Space complexity: O(m)

We create an array count with size O(m).
 */
