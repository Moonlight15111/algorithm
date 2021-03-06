package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 *
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
 * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0  输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1  输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2  输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *
 * @author Moonlight
 */
public class AllCellsDistOrder {

    public static void main(String[] args) {
        int[][] ints = allCellsDistOrder(1, 2, 0, 0);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }

        System.out.println();

        ints = allCellsDistOrder(2, 2, 0, 1);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }

        System.out.println();

        ints = allCellsDistOrder(2, 3, 1, 2);
        for (int[] i : ints) {
            System.out.print(Arrays.toString(i) + ", ");
        }
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // 求出所有的点sort
        int[][] ans = new int[rows * cols][];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i * cols + j] = new int[]{i, j};
            }
        }

        Arrays.sort(ans, Comparator.comparingInt(a -> (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter))));

        return ans;
    }

}
