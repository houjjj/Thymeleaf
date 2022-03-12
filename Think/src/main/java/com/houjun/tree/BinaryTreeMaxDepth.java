package com.houjun.tree;

/**
 * 求二叉树的最大深度
 */
public class BinaryTreeMaxDepth {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n3.left= n9;
        n3.right = n20;
        n20.left= n5;
        n20.right= n7;
        int depth = maxDepth(n3);
        System.out.println(depth);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

}
