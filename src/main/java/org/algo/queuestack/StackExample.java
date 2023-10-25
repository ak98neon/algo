package org.algo.queuestack;

import java.util.Stack;

/**
 * @link https://leetcode.com/problems/valid-parentheses/description/
 */
public class StackExample {

    public static void main(String[] args) {
//        String s = "{[()]]}";
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : s.toCharArray()) {
//            if (c == '{' || c == '[' || c == '(') {
//                stack.push(c);
//            } else if (c == '}' && stack.peek() == '{') {
//                stack.pop();
//            } else if (c == ']' && stack.peek() == '[') {
//                stack.pop();
//            } else if (c == ')' && stack.peek() == '(') {
//                stack.pop();
//            } else {
////                return false;
//            }
//        }
//
//        System.out.println(stack.isEmpty());

        String s = "()";
        var res = new Solution().isValid(s);
        System.out.println(res);
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            if (s.length() == 1) {
                return false;
            }

            for (char c : s.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                    continue;
                }

                if (stack.isEmpty()) {
                    return false;
                }

                char val = stack.peek();
                if (c == '}' && val == '{') {
                    stack.pop();
                } else if (c == ']' && val == '[') {
                    stack.pop();
                } else if (c == ')' && val == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }

}
