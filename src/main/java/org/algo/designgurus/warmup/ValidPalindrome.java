package org.algo.designgurus.warmup;

public class ValidPalindrome {

    public static void main(String[] args) {
        var sentence = "abac";
        var res = isPalindrome(sentence);
        System.out.println(res);
    }

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (Character.isLetterOrDigit(s.charAt(l)) && Character.isLetterOrDigit(s.charAt(r))) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            } else if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
        }

        return true;
    }
}
