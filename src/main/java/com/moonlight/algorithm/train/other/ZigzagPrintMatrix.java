package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.List;

/**
 * zigzag打印矩阵
 * 输入:
 *     [1, 2, 3
 *      4, 5, 6
 *      7, 8, 9]
 * 输出: 1，2，4，7，5，3，6，8，9
 *
 * @ClassName ZigzagPrintMatrix
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/3 20:13
 * @Version V1.0
 **/
public class ZigzagPrintMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        System.out.println(zigzag(a));
    }

    public static List<Integer> zigzag(int[][] matrix) {
        // 两个点 i, j 确定一条线，打印这条线
        int iX = 0;
        int iY = 0;
        int jX = 0;
        int jY = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isDown = false;
        List<Integer> res = new ArrayList<>();
        while (iX != m) {
            zigzag(matrix, iX, iY, jX, jY, res, isDown);
            iX = iY == n - 1 ? iX + 1 : iX;
            iY = iY == n - 1 ? iY : iY + 1;
            jY = jX == m - 1 ? jY + 1 : jY;
            jX = jX == m - 1 ? jX : jX + 1;
            isDown = !isDown;
        }
        return res;
    }
    
    public static void zigzag(int[][] matrix, int iX, int iY, int jX, int jY, List<Integer>  list, boolean isDown) {
        if (isDown) {
            while (iX != jX + 1) {
                list.add(matrix[iX++][iY--]);
            }
        } else {
            while (jX != iX - 1) {
                list.add(matrix[jX--][jY++]);
            }
        }
    }

}
