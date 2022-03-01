package com.houjun.tree;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n3.leftChild = n9;
        n3.rightChild = n20;
        n20.leftChild = n5;
        n20.rightChild = n7;
        int depth = maxDepth(n3);
        System.out.println(depth);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.leftChild);
        int rightDepth = maxDepth(root.rightChild);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    static class TreeNode {
        TreeNode leftChild;
        TreeNode rightChild;
        Integer val;

        TreeNode(int x) {
            val = x;
        }
    }
}
