package lakshmi.blind75;

import java.util.HashMap;


// Time Complexity: O(n)**
// You're iterating through the `input` array exactly **once** (`for (int i = 0; i < input.length; i++)`), which is **O(n)**
// Inside the loop:`hashMap.containsKey(complement)` → **O(1)** average case
// `hashMap.get(complement)` → **O(1)** average case
// `hashMap.put(input[i], i)` → **O(1)** average case
// So the total work done is linear in the number of elements in the array.

// Space Complexity: O(n)**
// In the **worst case**, if no pair is found, you'll end up inserting all `n`
// elements into the `HashMap`, so space grows linearly with the input size.
public class TwoSum {
    public static void main(String[] args) {
        int[] input = {1, 3, 5, 7};
        int target = 8;
        int[] indices = findTargetSumIndices(input, target);
        for (int n : indices) {
            System.out.println(n);
        }
    }

    private static int[] findTargetSumIndices(int[] input, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            if (hashMap.containsKey(complement)) {
                int index = hashMap.get(complement);
                return new int[] {index, i};
            }
            hashMap.put(input[i], i);
        }
       return new int[] {};
    }
}
