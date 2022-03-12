package com.houjun.tree;

/**
 * 前序遍历
 */
public class PrefixExpression {

    public static void main(String[] args) {
        Node root = new Node("-");
        Node plus = new Node("+");
        Node mul = new Node("*");
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        root.left = plus;
        root.right = d;

        plus.left = a;
        plus.right = mul;

        mul.left = b;
        mul.right = c;
        String s = toPrefixExpression(root);
        System.out.println(s);
    }

    /**
     * 前序遍历
     * @param node
     * @return
     */
    static String toPrefixExpression(Node node){
        if(node == null){
            return "";
        }
        String val = node.val;
        String left = toPrefixExpression(node.left);
        String right = toPrefixExpression(node.right);
        return val + left +  right;
    }

    static class Node {
        String val;
        Node left;
        Node right;
        Node parent;

        public Node(String val) {
            this.val = val;
        }
    }
}
