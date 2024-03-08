package org.algo.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        arr = quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] quickSort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int l, int r) {
        if (l >= r) {
            return arr;
        }

        var pivot = arr[r];
        int left = l;

        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                var tmp = arr[left];
                arr[left] = arr[i];
                arr[i] = tmp;
                left++;
            }
        }

        arr[r] = arr[left];
        arr[left] = pivot;

        sort(arr, l, left - 1);
        sort(arr, left + 1, r);

        return arr;
    }
}
