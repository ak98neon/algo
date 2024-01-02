package org.algo.leetcode.arrays;

//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
public class MergeStringsAlternately {

    public static void main(String[] args) {
        var word1 = "abc";
        var word2 = "pqr";
        var res = mergeAlternately(word1, word2);
        System.out.println(res);
    }

    public static String mergeAlternately(String word1, String word2) {
        var res = new StringBuilder();

        var i = 0;
        var minLen = Math.min(word1.length(), word2.length());

        for (; i < minLen; i++) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) {
            res.append(word1.substring(i));
        } else if (word1.length() < word2.length()) {
            res.append(word2.substring(i));
        }

        return res.toString();
    }
}
