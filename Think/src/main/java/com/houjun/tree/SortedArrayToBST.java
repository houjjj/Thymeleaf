package com.houjun.tree;

/**
 * 排序数组为平衡二叉树树
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode bst = sortedArrayToBST(nums);
        prefixTraversing(bst);
    }

    /**
     * 前序遍历
     *
     * @param bst
     */
    private static void prefixTraversing(TreeNode bst) {
        if(bst == null)
            return;
        System.out.println(bst.val);
        prefixTraversing(bst.left);
        prefixTraversing(bst.right);
    }

    /**
     * 方法一：递归构造平衡二叉树
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(nums, low, mid - 1);
        TreeNode right = sortedArrayToBST(nums, mid + 1, high);
        node.left = left;
        node.right = right;
        return node;
    }


}
