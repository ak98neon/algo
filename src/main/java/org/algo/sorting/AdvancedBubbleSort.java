package org.algo.sorting;

import java.util.Random;

public class AdvancedBubbleSort {

    public static void regularBubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void advancedBubbleSort(int[] nums) {
        int k = (int) Math.pow(nums.length, 0.5);

        for (int i = 0; i < nums.length; i += k) {
            sortSegment(nums, i, Math.min(i + k, nums.length));
        }

        sortSegment(nums, 0, nums.length);
    }

    public static void sortSegment(int[] nums, int start, int end) {
        boolean isSwapped;
        for (int i = start; i < end - 1; i++) {
            isSwapped = false;
            for (int j = start; j < end - 1 - (i - start); j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }

            // If no elements were swapped, the array is already sorted
            if (!isSwapped) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100_000;

        var random = new Random();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(1000);
        }
//        System.out.println(Arrays.toString(nums));

        var start = System.currentTimeMillis();
        advancedBubbleSort(nums);
        var end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");

//        System.out.println(Arrays.toString(nums));
    }
}
