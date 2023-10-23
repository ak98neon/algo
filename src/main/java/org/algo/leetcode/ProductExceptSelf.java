package org.algo.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        var arr = new int[]{-1, 1, 0, -3, 3};
        var result = new ProductExceptSelf().productExceptSelf(arr);
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {
        var k = nums.length;
        var result = new int[k];

        var left = 1;
        for (int i = 0; i < k; i++) {
            result[i] = left;
            left *= nums[i];
        }

        var right = 1;
        for (int i = k -1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
