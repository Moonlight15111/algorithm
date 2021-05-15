package com.moonlight.algorithm.train.contest.biweeklycontest52;

import java.util.Arrays;

/**
 * 给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
 * '#' 表示石头
 * '*' 表示固定的障碍物
 * '.' 表示空位置
 * 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，
 * 另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
 * 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
 * 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。
 * <p>
 * 输入：box = [["#",".","#"]]
 * 输出：[["."],
 * ["#"],
 * ["#"]]
 * <p>
 * 输入：box = [["#",".","*","."],
 * ["#","#","*","."]]
 * 输出：[["#","."],
 * ["#","#"],
 * ["*","*"],
 * [".","."]]
 * <p>
 * 输入：box = [["#","#","*",".","*","."],
 * ["#","#","#","*",".","."],
 * ["#","#","#",".","#","."]]
 * 输出：[[".","#","#"],
 * [".","#","#"],
 * ["#","#","*"],
 * ["#","*","."],
 * ["#",".","*"],
 * ["#",".","."]]
 * <p>
 * m == box.length
 * n == box[i].length
 * 1 <= m, n <= 500
 * box[i][j] 只可能是 '#' ，'*' 或者 '.' 。
 *
 * @ClassName RotateTheBox
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/15 22:55
 * @Version V1.0
 **/
public class RotateTheBox {

    public static void main(String[] args) {
        char[][] a = {
                {'#', '.', '#'}
        }, b = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        }, c = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };

        a = rotateTheBox(a);
        for (char[] chars : a) {
            System.out.println(Arrays.toString(chars));
        }

        System.out.println("=================================");

        b = rotateTheBox(b);
        for (char[] chars : b) {
            System.out.println(Arrays.toString(chars));
        }

        System.out.println("=================================");

        c = rotateTheBox(c);
        for (char[] chars : c) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] ans = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = box[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 1; j--) {
                while (j < m && ans[j][i] == '.' && ans[j - 1][i] == '#') {
                    ans[j][i] = '#';
                    ans[j - 1][i] = '.';
                    j++;
                }
            }
        }

        return ans;
    }

}
