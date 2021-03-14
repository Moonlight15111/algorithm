package com.moonlight.algorithm.train.backtrack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 *       任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 *       如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 * @ClassName SurroundedRegions
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/14 15:09
 * @Version V1.0
 **/
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] a = {
                {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        solve(a);
        for (char[] aaa : a) {
            System.out.println(Arrays.toString(aaa));
        }
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // 先找出边界或与边界连通的O，对其进行标记
        // 然后遍历矩阵，遇见标记就还原回O，否则置为X
        for (int i = 0, rowMax = board.length; i < rowMax; i++) {
            for (int j = 0, colMax = board[0].length; j < colMax; j++) {
                if ((i == 0 || j == 0 || i == rowMax - 1 || j == colMax - 1) && board[i][j] == 'O') {
                    backtrack(i, j, board);
                }
            }
        }
        for (int i = 0, rowMax = board.length; i < rowMax; i++) {
            for (int j = 0, colMax = board[0].length; j < colMax; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void backtrack(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O' || board[row][col] == ' ') {
            return;
        }
        board[row][col] = ' ';

        backtrack(row - 1, col, board);
        backtrack(row + 1, col, board);
        backtrack(row, col - 1, board);
        backtrack(row, col + 1, board);
    }

}
