package com.houjun.linked;

public class LinkedMain {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        deleteNode(listNode1);
        ListNode head = new ListNode(-1);
        head.next=listNode1;
        while(head.next!=null){
            System.out.println(head.next);
            head = head.next;
        }

    }

    /**
     * 删除链表中的节点
     * @param node
     */
    public static void deleteNode(ListNode node) {
           node.val = node.next.val;
           node.next=node.next.next;
//        node = node.next;
//        node.next = null;

    }

    /**
     * singly-linked
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

}
