package org.D0909;

import java.util.HashMap;

public class SubArraySumEqualsK {

    /*
    Algorithm

The idea behind this approach is as follows: If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same,
the sum of the elements lying in between those indices is zero. Extending the same thought further,
if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i]−sum[j]=k,
the sum of elements lying between indices i and j is k.

Based on these thoughts, we make use of a hashmap map which is used to store the cumulative sum up to all the indices
possible along with the number of times the same sum occurs. We store the data in the form: (sum.ofoccurrencesofsu).
We traverse over the array nums and keep on finding the cumulative sum.
Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum.
If the same sum occurs again, we increment the count corresponding to that sum in the hashmap.
Further, for every sum encountered, we also determine the number of times the sum sum−k has occurred already,
since it will determine the number of times a subarray with sum k has occurred up to the current index.
We increment the count by the same amount.

After the complete array has been traversed, the count gives the required result.

The animation below depicts the process.
     */

    /*
    Time complexity : O(n). The entire nums array is traversed only once.

Space complexity : O(n). Hashmap map can contain up to n distinct entries in the worst case.
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySumEqualsK().subarraySum(new int[]{1,1,1} , 2));
        System.out.println(new SubArraySumEqualsK().subarraySum(new int[]{1,2,3} , 3));
    }
}
