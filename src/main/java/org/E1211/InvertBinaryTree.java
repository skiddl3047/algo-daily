package org.E1211;

import org.D0901.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /*
    Complexity Analysis

Since each node in the tree is visited / added to the queue only once, the time complexity is O(n),
where n is the number of nodes in the tree.

Space complexity is O(n),
since in the worst case, the queue will contain all nodes in one level of the binary tree.
For a full binary tree, the leaf level has ceil of (n/2) which is n

 ⌉=O(n) leaves.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(root);
        System.out.println(new InvertBinaryTree().invertTree(root));
        System.out.println(root);
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
