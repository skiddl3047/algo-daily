package lakshmi.thryv;

import java.util.HashMap;

public class FibonaciSequence {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(fibo(n));
        System.out.println(fiboIterativeApproach(n));
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(fiboWithMap(n, map));
    }

    //Time Complexity:O(n)
    //Each value from 0 to n is computed only once and then reused.
    // Space Complexity:O(n)
    //Call stack: O(n) due to recursion.
    //HashMap stores up to n keys.
    private static int fiboWithMap(int n, HashMap<Integer, Integer> map) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if(map.containsKey(n)) {
            return map.get(n);
        }

        int result = fibo(n-1) + fibo(n-2);
        map.put(n, result);
        return result;
    }

    // Time Complexity: O(n)
    // One loop from 2 to n.
    // Space Complexity:O(1)
    // Only stores prev, current, and next.
    private static int fiboIterativeApproach(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0, current = 1;
        for(int i = 2; i <= n; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    //recursion
    //Time Complexity: O(2ⁿ)
    // Every call makes two more calls. So it's exponential.

    //Space Complexity: O(n)
    // Due to the recursive call stack going as deep as n.
    private static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n-1) + fibo(n-2);
    }
}
