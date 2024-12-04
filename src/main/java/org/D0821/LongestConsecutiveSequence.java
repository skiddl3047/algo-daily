package org.D0821;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
Time complexity : O(n).

Although the time complexity appears to be quadratic due to the while loop nested within the for loop,
closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks
the beginning of a sequence (i.e. currentNum-1 is not present in nums),
the while loop can only run for n iterations throughout the entire runtime of the algorithm.
This means that despite looking like O(n⋅n) complexity, the nested loops actually run in O(n+n)=O(n) time.
All other computations occur in constant time, so the overall runtime is linear.

Space complexity : O(n).

In order to set up O(1) containment lookups, we allocate linear space for a hash table to store the O(n) numbers in nums. Other than that,
the space complexity is identical to that of the brute force solution.
*/
    //First turn the input into a set of numbers. That takes O(n) and then we can ask in O(1) whether we have a certain number.
    //
    //Then go through the numbers. If the number x is the start of a streak (i.e., x-1 is not in the set), then test y = x+1, x+2, x+3, ...
    // and stop at the first number y not in the set.
    // The length of the streak is then simply y-x and we update our global best with that.
    // Since we check each streak only once, this is overall O(n).
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);

        int lcs = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int currentNum = num;
                int clcs = 1;
                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    clcs++;
                }
                lcs = Math.max(lcs, clcs);

            }
        }
        return lcs;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{1,0,2,3,4}));
    }
}
