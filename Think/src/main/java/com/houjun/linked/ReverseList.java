package com.houjun.linked;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = reverseList3(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static List<Arguments> reverseList2() {
        ArrayList<Arguments> list = new ArrayList<>();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        list.add(Arguments.arguments(head));
        return list;
    }

    /**
     * 解法一：迭代+新结点变首位
     *
     * @param listNode
     */
    @MethodSource
    @ParameterizedTest
    public void reverseList(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (listNode != null) {
            // 构建一个新结点，插入到head的前面; 想象成，你来当大哥，每个新结点都会成为大哥（head）
            ListNode node = new ListNode(listNode.val);
            node.next = head;
            head = node;
            // listNode 指针后移
            listNode = listNode.next;
        }
        ListNode dupHead = head;
        // 遍历head 链表，去掉 val为-1的结点
        while (dupHead != null) {
            if (dupHead.next == tail) {
                dupHead.next = null;
            }
            dupHead = dupHead.next;
        }
        // 打印
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 解法二：迭代
     *
     * @param head
     */
    @MethodSource
    @ParameterizedTest
    public void reverseList2(ListNode head) {
        if (head == null) {
            return;
        }
        // pre 是反转后的链表首结点
        ListNode pre = null;
        // curr 是传入的链表的每个遍历当前项
        ListNode curr = head;
        while (curr != null) {
            // 先把 next 独立拿出来，防止等会被覆盖
            ListNode next = curr.next;
            // 来了就做新大哥，新结点往链表的左侧添加
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 打印
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }

    /**
     * 解法三：递归
     *
     * @param head
     */
    public static ListNode reverseList3(ListNode head) {
        // 到最后一个结点返回
        if (head == null || head.next == null) {
            return head;
        }
        // 递归链表，返回值是 反转后的头结点，不用处理，一直返回到程序退出即可
        ListNode newHead = reverseList3(head.next);
        // 让head的下一个结点的next 指向head
        head.next.next = head;
        // 断开head指向下一个结点的指针
        head.next = null;
        return newHead;
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
