package com.houjun.tree;

import java.util.*;

/**
 * 二叉树的层次遍历
 */
public class LevelOrder {

    static List<List<Integer>> levels = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        List<List<Integer>> lists = levelOrder2(root);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    /**
     * DES：深度优先，递归算法
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        // 把根节点当作 第零层
        levelOrder(root, 0);
        return levels;
    }

    /**
     * 解法一DES：深度优先，递归算法
     */
    public static void levelOrder(TreeNode root, int level) {
        // 如果levels 的size 等于level层，说明第一次递归到了第level 层，需要建一个本层元素的ArrayList
        if (levels.size() == level)
            // 建一个本层使用的Arraylist
            levels.add(new ArrayList<>());
        // 获取第level层的元素list（一定有），向其中添加结点的值
        levels.get(level).add(root.val);
        // 如果左结点为null，就不向下递归了
        if (root.left != null)
            levelOrder(root.left, level + 1);
        // 如果右节点为null，就不详细递归了
        if (root.right != null)
            levelOrder(root.right, level + 1);
    }


    /**
     * 解法二BFS :Breath First Search 广度优先搜索
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        // 返回值
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        // 借用队列，把每层的结点都存入队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 存入根节点
        queue.offer(root);
        // 队列不为空，说明还有值没被处理
        while (!queue.isEmpty()) {
            // 本层结点都保存到level中
            List<Integer> level = new ArrayList<>();
            // 本层结点的个数
            int currentLevelSize = queue.size();
            // 从队列queue中挨个取出本层结点，并存入下层结点，由currentLevelSize 控制取本层的个数
            for (int i = 0; i < currentLevelSize; i++) {
                // 从队列中取出最早进入的结点
                TreeNode node = queue.poll();
                // 添加结点值到level
                level.add(node.val);
                // 如果下层的左子结点不为空，就入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果下层的右子节点不为空，就入队
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 把本层的结点集合level 作为单个对象添加到ret 返回值中。
            ret.add(level);
        }
        return ret;
    }

}
