package com.moonlight.algorithm.train.backtrack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题: https://leetcode-cn.com/problems/word-search/
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author Moonlight
 * @date 2021/3/10 15:46
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0, rowMax = board.length; i < rowMax; i++) {
            for (int j = 0, colMax = board[0].length; j < colMax; j++) {
                // 能找到第一个字符，后续的才有意义
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean backtrack(int row, int col, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        // 边界条件
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        // 处理已经遍历过的字符
        char tmp = board[row][col];
        board[row][col] = ' ';
        // 四个方向搜索
        boolean res = backtrack(row + 1, col, index + 1, board, word) || backtrack(row - 1, col, index + 1, board, word)
                || backtrack(row, col + 1, index + 1, board, word) || backtrack(row, col - 1, index + 1, board, word);
        board[row][col] = tmp;
        return res;
    }

}
