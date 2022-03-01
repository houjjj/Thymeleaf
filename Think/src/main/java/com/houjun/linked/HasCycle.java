package com.houjun.linked;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

/**
 * 判断链表是否有环
 */
public class HasCycle {

    public static List<Arguments> hasCycle2() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        ArrayList<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(head));
        return list;
    }

    /**
     * 解法1：hash表
     *
     * @param head
     */
    @ParameterizedTest
    @MethodSource
    public void hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
//                return true;
                System.out.println("存在");
            } else {
                head = head.next;
            }
        }
//        return false;
        System.out.println("不存在");
    }

    /**
     * 解法2：快慢指针
     *
     * @param head
     */
    @ParameterizedTest
    @MethodSource
    public void hasCycle2(ListNode head) {
        if (head == null) {
            System.out.println(false);
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if(fast == null || fast.next == null){
                System.out.println(false);
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(true);
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

