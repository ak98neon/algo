package org.algo.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
public class KidsWithGreatestNumberCandies {

    public static void main(String[] args) {
        var candies = new int[]{2, 3, 5, 1, 3};
        var extraCandies = 3;
        var res = kidsWithCandies(candies, extraCandies);
        System.out.println(res);
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var res = new ArrayList<Boolean>();
        var max = findMax(candies);

        for (var num : candies) {
            res.add(num + extraCandies >= max);
        }

        return res;
    }

    private static int findMax(int[] nums) {
        return Arrays.stream(nums).max()
                .orElseThrow();
    }
}
