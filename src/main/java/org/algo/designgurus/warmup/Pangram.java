package org.algo.designgurus.warmup;

import java.util.Arrays;
import java.util.HashSet;

public class Pangram {

    public static void main(String[] args) {
        String str = "TheQuickBrownFoxJumpsOverTheLazyDog";
        boolean res = checkIfPangram(str);
        System.out.println(res);
    }

    public static boolean checkIfPangram2(String sentence) {
        var set = new HashSet<Character>();

        for (char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                set.add(c);
            }
        }

        return set.size() == 26;
    }

    public static boolean checkIfPangram(String sentence) {
        int alphabetSize = 26;
        int[] arr = new int[alphabetSize];

        for (char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int val = c - 'a';
                arr[val]++;
            }
        }

        return Arrays.stream(arr)
                .allMatch(val -> val > 0);
    }
}
