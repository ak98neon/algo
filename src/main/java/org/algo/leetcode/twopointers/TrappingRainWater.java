package org.algo.leetcode.twopointers;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public static void main(String[] args) {
        var height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        var res = trap(height);
        System.out.println(res);
    }

    //Time O(n), Space O(1)
    private static int trap(int[] height) {
        var res = 0;
        var l = 0;
        var r = height.length - 1;
        var maxLeft = height[l];
        var maxRight = height[r];

        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }
        }

        return res;
    }
}
