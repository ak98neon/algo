package org.algo.arrays;

public class PrefixSum {

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 7};
        int[] prefixSums = computePrefixSums(candies);

        for (int sum : prefixSums) {
            System.out.print(sum + " ");
        }
        // This will print: 2 5 10 11 18
    }

    public static int[] computePrefixSums(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        return arr;
    }
}
