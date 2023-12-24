package org.algo.leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3)));
        var solution = new Solution();
        var reversed = solution.reverseList(head);

        ListNode temp = reversed;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private static class ListNode {
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

    //time = O(n), space O(1)
    private static class Solution {
        public ListNode reverseList(ListNode head) {
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
    }

}
