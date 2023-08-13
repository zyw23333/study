package org.example.leetcode;

/**
 * leetcode hot-100 104
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    public int dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            return depth;
        }
        else {
            return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
        }
    }

    public static void main(String[] args) {

    }
}
