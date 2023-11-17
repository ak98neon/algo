package org.algo.designgurus.warmup;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        var s = "rat";
        var t = "car";
        var result = isAnagram(s, t);
        System.out.println(result);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (char chr : map.keySet()) {
            if (map.get(chr) != 0) {
                return false;
            }
        }

        return true;
    }
}
