package org.algo.leetcode.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        var list = new ListNode(new ListNode(new ListNode(new ListNode(null, 4), 3), 2), 1);
//        list = reverseList(list);
        list = recursiveReverseList(list);
        System.out.println(list);
    }

    //Time O(n), Space O(1)
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    //Time O(n), Space O(n)
    public static ListNode recursiveReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        var newHead = head;
        if (newHead.next != null) {
            newHead = recursiveReverseList(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
