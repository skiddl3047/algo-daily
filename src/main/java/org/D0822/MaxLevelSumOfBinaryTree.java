package org.D0822;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBinaryTree {

    /*Time complexity: O(n).

Each queue operation in the BFS algorithm takes O(1) time, and a single node can only be pushed once, leading to O(n) operations for n nodes.
The computation of sum of all the values of nodes at a level also takes O(n) time as each node's value is used once.

Space complexity: O(n).
As the BFS queue stores the nodes in level-wise manner, the maximum number of nodes in the BFS queue
would equal to the most number of nodes at any level. So, the best case would be O(1) where all the levels have just one node.
The worst case would be a complete binary tree.
In a complete binary tree, the last or second last level would have the most nodes (the last level can have multiple null nodes).
Because we are iterating by level, the BFS queue will be most crowded when all of the nodes from
the last level (or second last level) are in the queue. Assume we have a complete binary tree with height h
and a fully filled last level having 2^h nodes. All the nodes at each level add up to 1+2+4+8+...+2^h =n.
This implies that ( (2^h+1) −1)=n, and thus 2^h =(n+1)/2. Because the last level h has 2^h nodes,
the BFS queue will have (n+1)/2=O(n) elements in the worst-case scenario.*/
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