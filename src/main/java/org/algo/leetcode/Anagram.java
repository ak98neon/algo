package org.algo.leetcode;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) {
        var s = "anagram";
        var t = "nagaram";
        System.out.println(
                new Anagram().isAnagram(s, t)
        );
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        var sMap = s.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var tMap = t.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return sMap.equals(tMap);
    }
}
