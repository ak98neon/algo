package org.algo.patterns.slidingwindow;

public class SlidingWindowBaseExample {

    public static void main(String[] args) {
        var nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        var k = 5;
        System.out.println(findLongestSubarrayWithSum(nums, k));
    }

    public static int findLongestSubarrayWithSum(int[] nums, int k) {
        var left = 0;
        var answer = 0;
        var curr = 0;

        for (var right = 0; right < nums.length; right++) {
            curr += nums[right];

            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
