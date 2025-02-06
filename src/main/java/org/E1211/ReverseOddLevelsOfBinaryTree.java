package org.E1211;

import org.D0901.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {

    public TreeNode reverseOddLevelsDFS(TreeNode root) {
        traverseDFS(root.left, root.right, 0);
        return root;
    }

    private void traverseDFS(TreeNode leftChild, TreeNode rightChild, int level) {
        if (leftChild == null || rightChild == null) {
            return;
        }
        //If the current level is odd, swap the values of the children.
        if (level % 2 == 0) { //if (level % 2 == 1) then you should call traverseDFS(root.left, root.right, 1);
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }
        traverseDFS(leftChild.left, rightChild.right, level + 1);
        traverseDFS(leftChild.right, rightChild.left, level + 1);
    }

    /*
    Complexity Analysis
Let n be the number of nodes in the tree.

Time complexity: O(n)

The algorithm iterates through the tree, processing each level of nodes.
The main loop performs BFS traversal, visiting each node exactly once, which results in a time complexity of O(n).

Additionally, at each level, the algorithm checks if it is odd and reverses the node values if necessary.
This operation occurs for each node in the queue and takes constant time per node.
The overall time complexity is dominated by the BFS traversal, resulting in O(n).

Space complexity: O(n)

The space used by the algorithm is determined by the queue that holds the nodes at each level during BFS traversal.
At most, the queue will hold all the nodes at one level,
which is bounded by the number of nodes in the tree, resulting in a space complexity of O(n).

Other space requirements are constant and do not contribute significantly to the space complexity.
Therefore, the overall space complexity is O(n).
     */
    public TreeNode reverseOddLevelsBFS(TreeNode root) {
        if (root == null)
            return null; // Return null if the tree is empty.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start BFS with the root node.
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                assert node != null;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse node values if the current level is odd.
            if (level % 2 == 1) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(
                            right
                    ).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root; // Return the modified tree root.
    }
}
