package org.algo.designgurus.twopointers;

import java.util.Arrays;

//Easy
//Time O(N), Space O(1)
public class TargetSum {

    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 4, 6};
        var target = 6;
        var res = search(arr, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            var sum = arr[left] + arr[right];

            if (sum == targetSum) {
                return new int[]{left, right};
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
