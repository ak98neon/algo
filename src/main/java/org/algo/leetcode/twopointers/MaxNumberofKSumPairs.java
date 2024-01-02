package org.algo.leetcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
public class MaxNumberofKSumPairs {

    public static void main(String[] args) {
        var nums = new int[]{3, 1, 3, 4, 3};
        var k = 6;
        var res = maxOperationsMap(nums, k);
        System.out.println(res);
    }

    //Time O(n logn) Space O(1)
    private static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        var res = 0;

        var l = 0;
        var r = nums.length - 1;

        while (l < r) {
            var sum = nums[l] + nums[r];
            if (sum == k) {
                res++;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            }
        }

        return res;
    }

    //Time O(n) Space O(n)
    private static int maxOperationsMap(int[] nums, int k) {
        if (nums.length < 2 || k < 1) {
            return 0;
        }

        var res = 0;

        var map = new HashMap<Integer, Integer>();
        for (var num : nums) {
            var val = k - num;

            if (map.containsKey(val)) {
                res++;

                if (map.get(val) == 1) {
                    map.remove(val);
                } else {
                    map.put(val, map.get(val) - 1);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return res;
    }
}
