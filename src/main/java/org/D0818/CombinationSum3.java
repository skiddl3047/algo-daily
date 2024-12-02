package org.D0818;

import java.util.ArrayList;
import java.util.List;
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 */
public class CombinationSum3 {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> tempList = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return list;
    }

    private void backtrack(int k, int remain, int start) {
        if(tempList.size() > k)
            return; /** no solution */
        else if(tempList.size() == k && remain == 0)
            list.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(k, remain-i, i+1);
                tempList.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3,7));
    }
}
