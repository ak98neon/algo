package org.algo.leetcode.linkedlist;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        var res = mergeTwoLists(list1, list2);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode(-1, null);
        var tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
    }

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
