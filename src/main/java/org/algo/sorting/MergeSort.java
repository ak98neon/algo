package org.algo.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = l + (r - l) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] aux = new int[r - l + 1];

        System.arraycopy(arr, l, aux, 0, aux.length);

        int i = 0;
        int j = m - l + 1;
        int k = l;

        while (i <= m - l && j < aux.length) {
            if (aux[i] <= aux[j]) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
            k++;
        }

        while (i <= m - l) {
            arr[k] = aux[i];
            i++;
            k++;
        }
    }
}
