package org.D0821;

import java.util.ArrayList;
import java.util.List;
/*
A sparse vector is a vector that has mostly zero values, while a dense vector is a vector where most of the elements are non-zero.
It is inefficient to store a sparse vector as a one-dimensional array (Approach 1).
Instead, we can store the non-zero values and their corresponding indices in a dictionary, with the index being the key (Approach 2).
 */
public class SparseVectorPairApproach {

    List<int[]> pairs;

    SparseVectorPairApproach(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }
    /*Let n be the length of the input array and L and L2 be the number of non-zero elements for the two vectors.

Time complexity: O(n) for creating the <index, value> pair for non-zero values; O(L+L2) for calculating the dot product.

Space complexity: O(L) for creating the <index, value> pairs for non-zero values. O(1) for calculating the dot product.*/
    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectorPairApproach vec) {
        int result = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) {
            // if index positions are same
            if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            }
            // if index positions p is greater than q
            else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                q++;
            }
            else {
                p++;
            }
        }
        return result;
    }
}