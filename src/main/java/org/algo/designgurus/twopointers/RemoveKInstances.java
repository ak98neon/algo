package org.algo.designgurus.twopointers;

//Easy
//Time O(n), Space O(1)
public class RemoveKInstances {

    public static void main(String[] args) {
        var arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        var key = 3;
        var res = remove(arr, key);
        System.out.println(res);
    }

    private static int remove(int[] arr, int key) {
        int nextPlace = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextPlace] = arr[i];
                nextPlace++;
            }
        }

        return nextPlace;
    }
}
