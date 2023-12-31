package org.algo.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum
//https://leetcode.com/problems/3sum/
public class ThreeSum {

    public static void main(String[] args) {
        var nums = new int[]{-1, 0, 1, 2, -1, -4};
        var res = threeSum(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var threeSum = num + nums[l] + nums[r];
                if (threeSum > 0) {
                    r--;
                } else if (threeSum < 0) {
                    l++;
                } else {
                    res.add(List.of(num, nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
