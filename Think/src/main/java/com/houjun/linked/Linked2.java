package com.houjun.linked;

public class Linked2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Linked2.ListNode listNode1 = new Linked2.ListNode(1);
        Linked2.ListNode listNode2 = new Linked2.ListNode(2);
        Linked2.ListNode listNode3 = new Linked2.ListNode(3);
        Linked2.ListNode listNode4 = new Linked2.ListNode(4);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        ListNode listNode = removeNthFromEnd(listNode1, 2);
        Linked2.ListNode head = new Linked2.ListNode();
        head.next = listNode;
        while (head.next != null) {
            System.out.println(head.next);
            head = head.next;
        }
    }

    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 统计链表长度
        int len = 0;
        // 使用指针对象遍历
        Linked2.ListNode point = new ListNode(-1,head);
        while (point.next != null) {
            point = point.next;
            len++;
        }
        // 如果链表长度和n相等，那么就是最简单的情况，直接返回head的next。作为新head
        if(len==n){
            return head.next;
        }
        // 再次初始化point，另point=head
        point = head;
        // 遍历len-n-1次，到目标结点的前一个结点上
        for (int i = 0; i < len - n - 1; i++) {
            point = point.next;
        }
        // 将前一个结点的next指向目标结点的next
        point.next = point.next.next;
        return head;
    }
}
