package org.algo.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    public static void main(String[] args) {
        var arr = new int[]{2, 7, 11, 15};
        var target = 9;
        var result = new TwoSum2().twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }

        int left = 0;
        int right = numbers.length - 1;

        var res = new int[2];
        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                res[0] = left;
                res[1] = right;
                return res;
            }

            if ((numbers[left] + numbers[right]) > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
