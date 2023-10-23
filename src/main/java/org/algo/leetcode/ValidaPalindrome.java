package org.algo.leetcode;

/**
 * @link https://leetcode.com/problems/valid-palindrome/
 */
public class ValidaPalindrome {

    public static void main(String[] args) {
        var s = " ";
        var result = new ValidaPalindrome().isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
