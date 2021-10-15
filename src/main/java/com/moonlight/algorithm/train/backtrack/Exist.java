package com.moonlight.algorithm.train.backtrack;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"  输出：true
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"  输出：false
 *
 */
public class Exist {

    public static void main(String[] args) {
        char[][] a = new char[][] {
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        char[][] b = new char[][] {
                {'a', 'b'}, {'c', 'd'}
        };
        System.out.println(exist(a, "ABCCED"));
        System.out.println(exist(b, "abcd"));
    }

    public static boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (backtrack(0, i, j, r, c, board, word.toCharArray())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(int idx, int i, int j, int r, int c, char[][] board, char[] toCharArray) {
        if (idx == toCharArray.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= r || j >= c || board[i][j] != toCharArray[idx]) {
            return false;
        }
        char ch = board[i][j];
        board[i][j] = ' ';

        boolean result = backtrack(idx + 1, i + 1, j, r, c, board, toCharArray) || backtrack(idx + 1, i, j + 1, r, c, board, toCharArray)
                         || backtrack(idx + 1, i - 1, j, r, c, board, toCharArray) || backtrack(idx + 1, i, j - 1, r, c, board, toCharArray);

        board[i][j] = ch;

        return result;
    }

}
