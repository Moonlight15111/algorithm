package com.moonlight.algorithm.train.other;

/**
 * 原题：https://leetcode-cn.com/problems/toeplitz-matrix/
 *
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]       输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * 输入：matrix = [[1,2],[2,2]]      输出：false
 * 解释：  对角线 "[1, 2]" 上的元素不同。
 *
 * 提示:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 *
 * 进阶：
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * @ClassName IsToeplitzMatrix
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/22 22:17
 * @Version V1.0
 **/
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        arr[0] = new int[]{1, 2, 3, 4};
        arr[1] = new int[]{5, 1, 2, 3};
        arr[2] = new int[]{9, 5, 1, 2};
        System.out.println(isToeplitzMatrix(arr));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0, row = matrix.length; i < row; i++) {
            for (int j = 0, col = matrix[i].length; j < col; j++) {
                if (j != col - 1 && i != row - 1) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
