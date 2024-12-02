package org.D0811;

import java.util.*;
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
 public class KthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        // List to store the sum of each level
        List<Long> levelSums = new ArrayList<>();
        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // Traverse each level in the tree
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long currentLevelSum = 0;
            // Calculate the sum of the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;
                // Add children to the queue
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            // Add the current level's sum to the list
            levelSums.add(currentLevelSum);
        }
        // Sort the list in descending order to find the kth largest sum
        levelSums.sort(Collections.reverseOrder());
        // Return the kth largest sum if there are at least k levels
        return k <= levelSums.size() ? levelSums.get(k - 1) : -1;
    }
    /*
        Time Complexity:  𝑂(𝑛) O(n), since each node is processed exactly once.
        Space Complexity:  𝑂(𝑘) O(k) for the min-heap that stores up to k level sums.
     */
     public long kthLargestLevelSumWithPriorityQueue(TreeNode root, int k) {
         if (root == null) return -1;

         // Min-heap to keep track of the largest k level sums
         PriorityQueue<Long> minHeap = new PriorityQueue<>(k);

         // Queue for BFS traversal
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         // Traverse each level in the tree
         while (!queue.isEmpty()) {
             int levelSize = queue.size();
             long currentLevelSum = 0;

             // Calculate the sum of the current level
             for (int i = 0; i < levelSize; i++) {
                 TreeNode node = queue.poll();
                 currentLevelSum += node.val;

                 // Add children to the queue
                 if (node.left != null) queue.offer(node.left);
                 if (node.right != null) queue.offer(node.right);
             }

             // Maintain only the largest k sums in the min-heap
             minHeap.offer(currentLevelSum);
             if (minHeap.size() > k) {
                 minHeap.poll();
             }
         }

         // If we have fewer than k levels, return -1
         return minHeap.size() == k ? minHeap.peek() : -1;
     }

     public static void main(String[] args) {


         TreeNode right21 = new TreeNode(3);
         TreeNode right22 = new TreeNode(7);
         TreeNode left31 = new TreeNode(4);
         TreeNode left32 = new TreeNode(6);
         TreeNode left21 = new TreeNode(2,left31, left32);
         TreeNode left22 = new TreeNode(1);
         TreeNode left1 = new TreeNode(8 , left21,left22);
         TreeNode right1 = new TreeNode(9 , right21,right22);
         TreeNode root = new TreeNode(5, left1, right1);
         System.out.println(new KthLargestLevelSum().kthLargestLevelSumWithPriorityQueue(root,2));
         System.out.println(new KthLargestLevelSum().kthLargestLevelSumWithPriorityQueue(root,3));


         left21 = new TreeNode(3);
         left1 = new TreeNode(2, left21, null);
         root = new TreeNode(1, left1, null);
         System.out.println(new KthLargestLevelSum().kthLargestLevelSumWithPriorityQueue(root,1));
     }
}

