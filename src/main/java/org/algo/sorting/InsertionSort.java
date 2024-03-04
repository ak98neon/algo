package org.algo.sorting;

/**
 * [5,4,3,2,1]
 * start from 4
 * check 5 > 4 if true replace them between each other
 * [4,5,3,2,1]
 * check 5 > 3 if true replace them util prev element > 3
 * [4,3,5,2,1]
 * [3,4,5,2,1]
 * check 5 > 2
 * [3,4,2,5,1]
 * [3,2,4,5,1]
 * [2,3,4,5,1]
 * check 5 > 1
 * ....
 * [1,2,3,4,5]
 * end
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j+1]) {
                var tmp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }

        return arr;
    }
}
