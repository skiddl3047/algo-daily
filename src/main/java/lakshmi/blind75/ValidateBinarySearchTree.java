package lakshmi.blind75;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n) — where n is the number of nodes in the binary tree.
// addToList() does a full traversal of all nodes → O(n)
// The loop that checks for strictly increasing order iterates through the list of size n - 1 → O(n)
// So total time complexity: O(n)

// Space Complexity:O(n)
// integerList stores all n node values → O(n)
// Recursion stack in worst case (unbalanced tree) can go up to depth n → O(n)
// So total space complexity is O(n)
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.setVal(2);
        TreeNode leftTreeNode = new TreeNode();
        leftTreeNode.setVal(1);
        TreeNode rightTreeNode = new TreeNode();
        rightTreeNode.setVal(3);
        treeNode.setLeft(leftTreeNode);
        treeNode.setRight(rightTreeNode);
        boolean isValid = validateBinarySearchTree(treeNode);
        System.out.println(isValid);
    }

    private static boolean validateBinarySearchTree(TreeNode treeNode) {
        List<Integer> integerList = new ArrayList<>();

        addToList(treeNode, integerList);

        for (int i = 0; i < integerList.size()-1; i++) {
            if(integerList.get(i) >= integerList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static void addToList(TreeNode treeNode, List<Integer> integerList) {
        if (treeNode == null) return;

        addToList(treeNode.left, integerList);
        integerList.add(treeNode.getVal());
        addToList(treeNode.right, integerList);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
