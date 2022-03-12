package com.houjun.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean result = isSymmetric2(root);
        System.out.println(result);
    }

    /**
     * 解法1：递归
     *
     * @param root
     * @return
     */
    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 判断根节点的左右子树
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        // 如果左右结点都是null 说明是叶子结点返回true
        if (left == null && right == null) {
            return true;
        }
        // 如果左结点为null 或者 右节点为null，或者左节点的val 不等于右节点，返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 重点是 如何选择左右结点，需要依照根节点相对称
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 迭代方式
     *
     * @param root
     * @return
     */
    private static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        // 如果队列不为空，就循环
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll(), right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            // 注意入队顺序，每两个结点都是关于根结点对称的
            // 左子节点的左节点和右子节点的右结点一对
            // 左子节点的右节点和右子节点的左结点一对
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

}
