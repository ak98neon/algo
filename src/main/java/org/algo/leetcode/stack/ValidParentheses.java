package org.algo.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        var s = "()[]{}";
        var res = isValid(s);
        System.out.println(res);
    }

    private static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        var stack = new Stack<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            var value = stack.peek();
            if (ch == '}' && value == '{') {
                stack.pop();
            } else if (ch == ']' && value == '[') {
                stack.pop();
            } else if (ch == ')' && value == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
