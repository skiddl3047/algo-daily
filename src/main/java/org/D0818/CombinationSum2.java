package org.D0818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> list = new LinkedList<>();
            Arrays.sort(candidates);
            backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

            if(remain < 0)
                return; /** no solution */
            else if(remain == 0){
                list.add(new ArrayList<>(tempList));
                System.out.println(Arrays.toString(tempList.toArray()));
            }
            else{
                for (int i = start; i < cand.length; i++) {
                    /*
                        The condition if (i > start && nums[i] == nums[i - 1]) makes sure
                        that you don't pick the same number more than once in the same iteration level, thus preventing duplicate combinations.
                     */
                    if(i > start && cand[i] == cand[i-1])
                        continue; /** skip duplicates */

                    if(cand[i] < remain){
                        tempList.add(cand[i]);
                        backtrack(list, tempList, cand, remain - cand[i], i+1);
                        tempList.removeLast();
                    }
                }
            }
        }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
