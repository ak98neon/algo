package org.algo.leetcode.arrays;

import java.util.Set;

public class ReverseVowelsofString {

    public static void main(String[] args) {
        var str = "hello";
        var res = reverseVowels(str);
        System.out.println(res);
    }

    private static String reverseVowels(String s) {
        var res = new StringBuilder(s);
        var set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        var l = 0;
        var r = s.length() - 1;

        while (l < r) {
            while (!set.contains(s.charAt(l)) && l < r) {
                l++;
            }

            while (!set.contains(s.charAt(r)) && l < r) {
                r--;
            }

            var temp = s.charAt(l);
            res.setCharAt(l, s.charAt(r));
            res.setCharAt(r, temp);
            l++;
            r--;
        }

        return res.toString();
    }
}
