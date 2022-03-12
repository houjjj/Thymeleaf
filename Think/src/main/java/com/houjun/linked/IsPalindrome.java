package com.houjun.linked;

import java.util.HashMap;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(3))));
        boolean result = isPalindrome(l1);
        System.out.println(result);
    }

    private static boolean isPalindrome(ListNode head) {
        // 首先构建一个逆序的链表
        ListNode curr = head;
        ListNode tail = null;
        while (curr != null) {
            tail = new ListNode(curr.val, tail);
            curr = curr.next;
        }
        while (tail != head && head != null && tail != null) {
            if (tail.val != head.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
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
