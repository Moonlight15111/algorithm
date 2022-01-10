package com.moonlight.algorithm.train.design;

/**
 * https://leetcode-cn.com/problems/subrectangle-queries/
 *
 * 请你实现一个类 SubrectangleQueries ，
 * 它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），
 * 并支持以下两种操作：
 *   1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *      用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 *   2. getValue(int row, int col)
 *     返回矩形中坐标 (row,col) 的当前值。
 *
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // 返回 100
 * subrectangleQueries.getValue(2, 2); // 返回 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // 返回 20
 *
 * @author Moonlight
 */
public class SubrectangleQueries {

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{
                {1, 1, 1}, {2, 2, 2}, {3, 3, 3}
        });
        System.out.println(subrectangleQueries.getValue(0, 0));
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        System.out.println(subrectangleQueries.getValue(0, 0));
        System.out.println(subrectangleQueries.getValue(2, 2));
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
        System.out.println(subrectangleQueries.getValue(2, 2));
    }

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }


}
