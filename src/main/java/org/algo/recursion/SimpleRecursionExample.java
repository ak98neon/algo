package org.algo.recursion;

public class SimpleRecursionExample {

    public static void main(String[] args) {
        print(1);
    }

    private static void print(int i) {
        if (i > 10) {
            return;
        }

        System.out.println(i);
        print(i + 1);
    }
}
