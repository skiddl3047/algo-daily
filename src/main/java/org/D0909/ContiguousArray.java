package org.D0909;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {


    /*
    Time complexity : O(n). The entire array is traversed only once.
    Space complexity : O(n). Maximum size of the HashMap map will be n, if all the elements are either 1 or 0.
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                //The variable count is used as a running total that increases by 1 for each 1 and decreases by 1 for each 0.
                //When the same count value appears at two different indices, it means that the subarray between these indices has an equal number of 0s and 1s.
                //When a specific count is found in the map, it means that from the index stored in the map (map.get(count)) to the current index (i), the subarray has a balanced number of 0s and 1s.
                //The length of this subarray is: length=i−map.get(count)
                //Since we are looking for the maximum length of such subarrays, we compare the current longest length (maxlen) with the newly calculated length (i - map.get(count)).
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0,1,0,0,1,1,0}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0,1,0}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0,1}));
    }
}
