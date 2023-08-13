package org.example.leetcode;

/**
 * leetcode hot-100 101
 */
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private static boolean recur(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        boolean flag = left.val == right.val;
        flag &= recur(left.left, right.right);
        return flag & recur(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        TreeNode test1 = new TreeNode(2);
        TreeNode test2 = new TreeNode(2);
        test.left = test1;
        test.right = test2;
        TreeNode test3 = new TreeNode(3);
        TreeNode test4 = new TreeNode(4);
        TreeNode test5 = new TreeNode(4);
        TreeNode test6 = new TreeNode(3);
        test1.left = test3;
        test1.right = test4;
        test2.left = test5;
        test2.right = test6;
        System.out.println(isSymmetric(test));
    }
}
