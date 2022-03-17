package com.houjun.design;

/**
 * 最小栈
 */
class MinStack {
    Node head;
    int min;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, null);
        } else {
            head = new Node(val, head);
        }
        min = min == 0 ? val : Math.min(val, min);
    }

    public void pop() {
        if(head == null)
            throw new IllegalStateException("stack is null");
        head = head.next;
        if (head == null) {
            min = 0;
            return;
        }
        min = head.val;
        Node curr = head;
        while (curr != null) {
            min = Math.min(min, curr.val);
            curr = curr.next;
        }
    }

    public int top() {
        if(head == null)
            throw new IllegalStateException("stack is null");
        return head.val;
    }

    public int getMin() {
        if(head == null)
            throw new IllegalStateException("stack is null");
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}