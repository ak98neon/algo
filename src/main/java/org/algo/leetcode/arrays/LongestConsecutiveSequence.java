package org.algo.leetcode.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        var res = longestConsecutive(arr);
        System.out.println(res);
    }

    public static int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        var longest = 0;

        for (var num : set) {
            if (!set.contains(num - 1)) {
                int length = 0;
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
