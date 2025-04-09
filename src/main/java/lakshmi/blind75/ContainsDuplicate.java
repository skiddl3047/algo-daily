package lakshmi.blind75;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// You're iterating through the nums array once (for (int n : nums)), which takes O(n) time where n is the length of the array.
// For each element, hashSet.contains(n) and hashSet.add(n) operations are both O(1) on average (due to hashing).
// So, overall it's a single pass with constant-time operations per element, resulting in O(n) time.

// Complexity: O(n)
// In the worst case, where there are no duplicates, all n elements will be added to the HashSet.
// So, the HashSet will grow linearly with the size of the input, leading to O(n) additional space
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] input = {1, 3, 5, 7,9};
        boolean containsDuplicate = containsDuplicate(input);
        System.out.println(containsDuplicate);
        containsDuplicate = containsDuplicate1(input);
        System.out.println(containsDuplicate);
    }

    private static boolean containsDuplicate(int[] input) {
        boolean containsDuplicate = false;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int n : input) {
           if (hashSet.contains(n)) {
               containsDuplicate = true;
               break;
           }
           hashSet.add(n);
        }
        return containsDuplicate;
    }

    private static boolean containsDuplicate1(int[] input) {
        Set<Integer> hashSet = new HashSet<>();
        for (int n : input) {
            if (!hashSet.add(n)) {
                return true;
            }
        }
        return false;
    }
}
