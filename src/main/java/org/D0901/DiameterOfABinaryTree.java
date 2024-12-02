package org.D0901;

public class DiameterOfABinaryTree {

    private int maxDiameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
    /*
    Let N be the number of nodes in the tree.

Time complexity: O(N). This is because in our recursion function longestPath,
we only enter and exit from each node once. We know this because each node is entered from its parent,
and in a tree, nodes only have one parent.

Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS,
which relates to the height of the tree. In the worst case, the tree is skewed so the height of the tree is O(N).
If the tree is balanced, it'd be O(logN).
    */
    private int depth(TreeNode root){
        if(root==null)
            return 0;
        // recursively find the longest path in both left child and right child
        int left = depth(root.left);
        int right = depth(root.right);
        maxDiameter = Math.max(maxDiameter,left+right);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(left,right)+1;
    }
}
