package org.D0819;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.


Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */
public class Permutations {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    /*
    Given n as the length of nums,

Time complexity, what you should say in an interview: O(n⋅n!)
Finding permutations is a well-studied problem in combinatorics. Given a set of length n,
the number of permutations is n! (n factorial). There are n options for the first number, n−1 for the second, and so on.
For each of the n! permutations, we need O(n) work to copy curr into the answer. This gives us O(n⋅n!) work.

Space complexity: O(n)

We don't count the answer as part of the space complexity.
The extra space we use here is for curr and the recursion call stack.
The depth of the call stack is equal to the length of curr, which is limited to n.

     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrack(list, tempList, nums);
                //System.out.println("Before removing last " + Arrays.deepToString(tempList.toArray()) + " Current List : " + Arrays.deepToString(list.toArray()));
                tempList.removeLast();
                //System.out.println("After removing last " + Arrays.deepToString(tempList.toArray()));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }
}
