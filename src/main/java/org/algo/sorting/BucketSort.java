package org.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bucketSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bucketSort(int[] arr) {
        var n = arr.length;

        if (n == 0)
            return;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = arr[i] * n;
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
