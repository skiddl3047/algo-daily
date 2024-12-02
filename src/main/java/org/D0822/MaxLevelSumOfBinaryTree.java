package org.D0822;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        if (root == null) return -1;

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level =0;
        int maxlevel = 1;
        long maxsum = 0;
        // Traverse each level in the tree
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long currentLevelSum = 0;
            level++;

            // Calculate the sum of the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;

                // Add children to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if(maxsum < currentLevelSum){
                maxsum = currentLevelSum;
                maxlevel = level;
            }


        }
        return maxlevel;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}