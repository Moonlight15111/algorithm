package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * @ClassName FindDiagonalOrder
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/4 19:18
 * @Version V1.0
 **/
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(a)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, index = 0;
        int[] ans = new int[m * n];
        int iX = 0, iY = 0, jX = 0, jY = 0;
        boolean isDown = false;

        while (iX != m) {
            index = process(iX, iY, jX, jY, isDown, mat, ans, index);
            iX = iY == n - 1 ? iX + 1 : iX;
            iY = iY == n - 1 ? iY : iY + 1;
            jY = jX == m - 1 ? jY + 1 : jY;
            jX = jX == m - 1 ? jX : jX + 1;
            isDown = !isDown;
        }

        return ans;
    }

    private static int process(int iX, int iY, int jX, int jY, boolean isDown, int[][] mat, int[] ans, int index) {
        if (isDown) {
            while (iX != jX + 1) {
                ans[index++] = mat[iX++][iY--];
            }
        } else {
            while (jX != iX - 1) {
                ans[index++] = mat[jX--][jY++];
            }
        }
        return index;
    }

}
