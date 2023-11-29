package org.algo.designgurus.twopointers;

//Easy
//Time O(n), Space O(1)
public class NonDuplicateNumberInstances {

    public static void main(String[] args) {
        var arr = new int[]{2, 2, 2, 11};
        var res = remove(arr);
        System.out.println(res);
    }

    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }
}
