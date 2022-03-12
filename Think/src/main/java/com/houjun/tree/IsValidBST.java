package com.houjun.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(Integer.MIN_VALUE), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
        boolean valid = isValidBST2(node);
        System.out.println(valid);
    }

    /**
     * 解法一 :递归算法
     * @param node
     * @return
     */
    private static boolean isValidBST(TreeNode node) {
        return isValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        // 如果结点的val值不在 low-high 的这个范围内，返回false，如果等于边界值
        if (val >= high || val <= low) {
            return false;
        }
        return isValidBST(node.left, low, val) && isValidBST(node.right, val, high);
    }

    /**
     * 解法二：中序遍历 左根右
     * @param root
     * @return
     */
    static boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
