package org.algo.arrays;

public class SlidingWindowExample {
    public static void main(String[] args) {
        var arr = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(
                maxSumInArrSlidingWindow(arr, 3)
        );
    }

    public static int maxSumInArrSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        int initSum = 0;
        for (var i = 0; i < k; i++) {
            initSum += arr[i];
        }

        int maxSum = initSum;
        for (var i = k; i < arr.length; i++) {
            initSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, initSum);
        }

        return maxSum;
    }
}
