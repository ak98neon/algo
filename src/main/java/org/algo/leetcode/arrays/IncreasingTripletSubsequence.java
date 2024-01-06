package org.algo.leetcode.arrays;

//https://leetcode.com/problems/increasing-triplet-subsequence
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5};
        var res = increasingTriplet(nums);
        System.out.println(res);
    }

    private static boolean increasingTriplet(int[] nums) {
        var small = Integer.MAX_VALUE;
        var mid = Integer.MAX_VALUE;

        for (var big : nums) {
            if (big <= small) {
                small = big;
            } else if (big <= mid) {
                mid = big;
            } else {
                return true;
            }
        }

        return false;
    }
}
