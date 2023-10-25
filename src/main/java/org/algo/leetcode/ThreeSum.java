package org.algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) { // Step 2: Fix one element
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate elements
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> result = obj.threeSum(nums, target);
        System.out.println(result);
    }
}
