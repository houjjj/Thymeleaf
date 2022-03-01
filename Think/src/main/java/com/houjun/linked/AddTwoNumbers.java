package com.houjun.linked;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {

    @ParameterizedTest
    @MethodSource
    public void addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否进位的标志
        int flag = 0;
        // 构建一个head 之前的结点，以备下面算出的首个值能放入head，利用ListNode(int val, ListNode next)构造器
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        // 单单是进位标志有值也能进入循环
        while (l1 != null || l2 != null || flag != 0) {
            int sum = 0;
            // 如果l1 不为null，就把他上面val加到sum上，指针后移
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 如果l2 不为null，就把他上面val加到sum上，指针后移
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 加上进位标识符上的值[0、1]，指针后移
            sum += flag;
            // 如果大于9，有进位，
            if (sum > 9) {
                flag = 1;
            } else {
                flag = 0;
            }
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static List<Arguments> addTwoNumbers() {
        List<Arguments> list = new ArrayList();
        ListNode l1 = new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        list.add(Arguments.arguments(l1, l2));
        return list;
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

