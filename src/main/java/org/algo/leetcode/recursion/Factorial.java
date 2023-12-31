package org.algo.leetcode.recursion;

public class Factorial {

    public static void main(String[] args) {
        var res = factorial(5);
        System.out.println(res);
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
