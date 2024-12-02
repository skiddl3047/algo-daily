package org.D0901;


import javafx.util.Pair;

import java.util.*;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/editorial/?envType=problem-list-v2&envId=breadth-first-search
public class BinaryTreeVerticalOrderTraversal {


    /*
    Time Complexity: O(N) where N is the number of nodes in the tree.


Following the same analysis in the previous BFS approach, the only difference is that this time we don't need the costy sorting operation (i.e. O(NlogN)).

Space Complexity: O(N) where N is the number of nodes in the tree. The analysis follows the same logic as in the previous BFS approach.


     */
    /*
    The key insight is that we only need to know the range of the column index (i.e. [min_column, max_column]).
    Then we can simply iterate through this range to generate the outputs without the need for sorting.
     */
    public List<List<Integer>> verticalOrderBFSApproach(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
        // Pair of node and its column offset
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair<>(root, column));

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }
        for(int i = minColumn; i < maxColumn + 1; ++i) {
            output.add(columnTable.get(i));
        }

        return output;
    }
}
