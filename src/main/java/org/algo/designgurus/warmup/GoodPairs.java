package org.algo.designgurus.warmup;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

//Easy
public class GoodPairs {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 1, 1, 3};
        var res = numGoodPairs(nums);
        System.out.println(res);
    }

    public static int numGoodPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] pairCount = {0};

        stream(nums).forEach(num -> {
            map.put(num, map.getOrDefault(num, 0) + 1);
            pairCount[0] += map.get(num) - 1;
        });

        return pairCount[0];
    }
}
