package lakshmi.blind75;

// Time Complexity
// The function isSameTree(p, q) performs a recursive traversal of both trees simultaneously.
// At each recursive step, it compares the current nodes' values.
// Then it recurses on the left and right children.
// If both trees have n nodes, the algorithm visits each node exactly once.
// Time Complexity = O(n), where n is the number of nodes in the tree (assuming both trees are of size n).

// Space Complexity:
// Worst Case: O(h), where h is the height of the smaller tree.
// This is due to the recursion stack.
// In the worst case (a skewed tree), the recursion depth is O(n) (if the tree is a straight line).
// For a balanced tree, the space complexity is O(log n) because the height is logarithmic in the number of nodes.
public class SameTree {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode();
        treeNode1.setVal(5);
        TreeNode treeNode2 = new TreeNode();
        treeNode1.setVal(4);

        boolean isSameTree = isSameTree(treeNode1, treeNode2);
        System.out.println(isSameTree);

    }

    private static boolean isSameTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null & treeNode2 == null) return true;
        if (treeNode1 == null || treeNode2 == null) return false;
        if (treeNode1.val !=  treeNode2.val) return false;
        return isSameTree(treeNode1.left, treeNode2.left) &&
                isSameTree(treeNode1.right, treeNode2.right);
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

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }
    }
}
