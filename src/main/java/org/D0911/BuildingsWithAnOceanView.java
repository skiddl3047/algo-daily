package org.D0911;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingsWithAnOceanView {

    /*
    Time complexity: O(N).
We iterate over the given array once, and for each building height, we perform a constant number of operations.
The answer array is reversed at the end, which also takes O(N) time.
In Java, copying the elements from the array list to an integer array in reverse order also takes O(N).

Space complexity: O(1).
No auxiliary space was used other than for the output array.
Although, in Java, in order to maintain a dynamic size array (since we don't know the size of the output array at the beginning),
we created an extra Array List that supports fast O(1) push operation.
Array List can contain at most N elements, hence for the Java solution, the space complexity is O(N).
    */
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        int maxHeight = -1;
        for (int current = n - 1; current >= 0; --current) {
            // If there is no building higher (or equal) than the current one to its right, push it in the list.
            if (maxHeight < heights[current]) {
                list.add(current);
                maxHeight = heights[current];// Update max building till now.
            }
        }
        // Push building indices from list to answer array in reverse order.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(list.size() - 1 - i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BuildingsWithAnOceanView().findBuildings(new int[]{4, 2, 3, 1})));
    }

    // followup question - if we have an ocean view from both sides , ie : left and right . how do we do it in one pass
    //https://leetcode.com/problems/buildings-with-an-ocean-view/editorial/comments/2680646
}
