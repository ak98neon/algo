package org.algo.dsa.heap;

import java.util.ArrayList;

public class PercolationExample {

    public static void main(String[] args) {
        var heap = new ArrayList<Integer>();
        heap.add(0);


    }

    public static void percolateUp(ArrayList<Integer> heap, int index) {
        while (index > 1) {
            int parentIndex = index / 2;
            if (heap.get(index) < heap.get(parentIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public static void percolateDown(ArrayList<Integer> heap, int index) {
        while (index < heap.size()) {
            int leftIndex = index * 2;
            int rightIndex = index * 2 + 1;
            if (leftIndex >= heap.size()) {
                break;
            }
            int minIndex = leftIndex;
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(leftIndex)) {
                minIndex = rightIndex;
            }
            if (heap.get(index) > heap.get(minIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);
                index = minIndex;
            } else {
                break;
            }
        }
    }
}
