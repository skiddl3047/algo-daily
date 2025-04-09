package amazon.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    Time complexity: O(n).
    We traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.

    Space complexity: O(n).
    The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3,3}, 6)));
    }
}
