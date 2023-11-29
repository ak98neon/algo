package org.algo.designgurus.twopointers;

import java.util.Arrays;
import java.util.Collections;

public class SquaringSortedArray {

    public static void main(String[] args) {
        var input = new int[]{-2, -1, 0, 2, 3};
        var result = makeSquares(input);
        System.out.println(Arrays.toString(result));
    }

    //Time O(N) Space O(n)
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }

        return squares;
    }

    //Worth because of sorting operation leads to O(N * logN)
    public static int[] makeSquaresStream(int[] arr) {
        return Arrays.stream(arr)
                .map(i -> i * i)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
