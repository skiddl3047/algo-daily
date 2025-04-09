package org.D0901;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
      public int val;
      public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }

    @Override
    public String toString() {
        List<List<String>> levels = new ArrayList<>();
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(this);

        // Build levels
        while (!currentLevel.isEmpty()) {
            List<String> level = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            boolean hasNonNull = false;

            for (TreeNode node : currentLevel) {
                if (node == null) {
                    level.add("");
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    level.add(String.valueOf(node.val));
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                    hasNonNull |= (node.left != null || node.right != null);
                }
            }

            levels.add(level);
            if (!hasNonNull) break;
            currentLevel = nextLevel;
        }

        // Calculate spacing
        int totalWidth = (int) Math.pow(2, levels.size()) - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < levels.size(); i++) {
            List<String> level = levels.get(i);
            int spacesBetween = (int) Math.pow(2, levels.size() - i - 1) - 1;
            int leadingSpaces = (int) Math.pow(2, levels.size() - i - 1) - 1;

            sb.append(" ".repeat(leadingSpaces));
            for (int j = 0; j < level.size(); j++) {
                sb.append(level.get(j).isEmpty() ? " " : level.get(j));
                if (j < level.size() - 1) {
                    sb.append(" ".repeat(spacesBetween));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}

