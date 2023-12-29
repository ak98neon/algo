package org.algo.leetcode;

import java.util.HashSet;

//36. Valid Sudoku
//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        var isValid = isValidSudoku(board);
        System.out.println(isValid); //true
    }

    //Time O(1) Space O(1)
    public static boolean isValidSudoku(char[][] board) {
        var seen = new HashSet<String>();

        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    var b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
