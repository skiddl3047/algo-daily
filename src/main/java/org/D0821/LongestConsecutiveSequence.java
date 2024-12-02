package org.D0821;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

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
