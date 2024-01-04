package org.algo.leetcode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/can-place-flowers
public class CanPlaceFlowers {

    public static void main(String[] args) {
        var flowers = new int[]{1, 0, 0, 0, 0, 0, 1};
        var n = 2;
        var res = canPlaceFlowers(flowers, n);
        System.out.println(res);
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        var res = 0;

        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 0) {
                var l = Math.max(i - 1, 0);
                var r = Math.min(i + 1, flowerbed.length - 1);
                if (flowerbed[l] == 0 && flowerbed[r] == 0) {
                    res++;
                    i += 2;
                    continue;
                }
            }
            i++;
        }

        return res >= n;
    }
}
