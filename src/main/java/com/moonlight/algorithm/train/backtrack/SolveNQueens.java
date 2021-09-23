package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *
 * 输入：n = 1 输出：[["Q"]]
 *
 */
public class SolveNQueens {

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] b = new char[n][n];
        for (char[] c : b) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, b, ans);

        return ans;
    }

    private static void backtrack(int n, int r, char[][] b, List<List<String>> ans) {
        if (r == n) {
            ans.add(toList(b));
            return;
        }
        for (int c = 0; c < n; c++) {
            if (valid(r, c, n, b)) {
                b[r][c] = 'Q';
                backtrack(n, r + 1, b, ans);
                b[r][c] = '.';
            }
        }
    }

    private static boolean valid(int r, int c, int n, char[][] b) {
        for (int i = 0; i < r; i++) {
            if (b[i][c] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < c; i++) {
            if (b[r][i] == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> toList(char[][] b) {
        List<String> res = new ArrayList<>();
        for (char[] c : b) {
            res.add(new String(c));
        }
        return res;
    }

}
