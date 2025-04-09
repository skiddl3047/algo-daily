package org.E1215;

import org.D0901.TreeNode;

import java.util.LinkedList;

public class KthSmallestElementInBST {


    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2,
                                new TreeNode(1),null), new TreeNode(4)),
                new TreeNode(6));
    }
}
