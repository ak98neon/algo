package org.algo.patterns.slidingwindow;

public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        var nums = new int[]{10, 5, 2, 6};
        var k = 100;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
