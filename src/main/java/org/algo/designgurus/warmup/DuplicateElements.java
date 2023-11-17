package org.algo.designgurus.warmup;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DuplicateElements {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 6, 6};
        var res = hasDuplicates(arr);
        System.out.println(res);
    }

    //Best Solution time O(n * logn) space O(1) - O(n) depends on sorting algo
    public static boolean hasDuplicates(int[] nums) {
        Arrays.sort(nums);
        return IntStream.range(0, nums.length - 1)
                .anyMatch(i -> nums[i] == nums[i + 1]);
    }

    //Time O(n) Space O(n)
//    public static boolean hasDuplicates(int[] nums) {
//        var set = new HashSet<Integer>();
//
//        for (var num : nums) {
//            if (set.contains(num)) {
//                return true;
//            } else {
//                set.add(num);
//            }
//        }
//
//        return false;
//    }

//    public static boolean hasDuplicates(int[] nums) {
//        return Arrays.stream(nums).distinct().count() != nums.length;
//    }
}
