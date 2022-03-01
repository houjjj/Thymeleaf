package com.houjun.linked;

public class MergeSortedLined {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode next = l1.next;
                pre.next = l1;
                pre = pre.next;
                l1 = next;
            } else {
                ListNode next = l2.next;
                pre.next = l2;
                pre = pre.next;
                l2 = next;
            }
        }
        // 两个链表中总有一个是先遍历完，导致另一个链表有剩余结点
        if (l1 != null) {
            pre.next = l1;
        } else {
            pre.next = l2;
        }
        return head.next;
    }

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
    }
}
