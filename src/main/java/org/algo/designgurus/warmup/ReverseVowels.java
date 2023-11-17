package org.algo.designgurus.warmup;

import java.util.Set;

public class ReverseVowels {

    public static void main(String[] args) {
        var sentence = "DesignGUrus";
        var res = reverseVowels(sentence);
        System.out.println(res);
    }

    public static String reverseVowels(String s) {
        final var vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        var l = 0;
        var r = s.length() - 1;
        var array = s.toCharArray();

        while (l < r) {
            if (vowels.contains(array[l])) {
                if (vowels.contains(array[r])) {
                    var temp = array[l];
                    array[l] = array[r];
                    array[r] = temp;
                    l++;
                    r--;
                    continue;
                }

                while (l < r && !vowels.contains(array[r])) {
                    r--;
                }
            } else {
                l++;
            }
        }
        return new String(array);
    }
}
