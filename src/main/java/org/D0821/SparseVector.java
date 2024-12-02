package org.D0821;

import java.util.ArrayList;
import java.util.List;

public class SparseVector {

    private int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int length = this.nums.length;
        int result = 0;
        for(int i=0; i< length; i++)
            result += (this.nums[i] * vec.nums[i]);

        return result;
    }

    List<int[]> pairs;

    SparseVector(int[] nums, int k) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProductWithPairs(SparseVector vec) {
        int result = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) {
            if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            }
            else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                q++;
            }
            else {
                p++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SparseVector v1 = new SparseVector(new int[]{1,0,0,2,3});
        SparseVector v2 = new SparseVector(new int[]{0,3,0,4,0});
        System.out.println(v1.dotProduct(v2));
        SparseVector v3 = new SparseVector(new int[]{0,1,0,0,0});
        SparseVector v4 = new SparseVector(new int[]{0,0,0,0,2});
        System.out.println(v3.dotProduct(v4));
    }
}


