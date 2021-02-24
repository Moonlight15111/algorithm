package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/flipping-an-image/
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]    输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；  然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]  输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * @ClassName FlipAndInvertImage
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/24 22:45
 * @Version V1.0
 **/
public class FlipAndInvertImage {

    public static void main(String[] args) {
        int[][] A = new int[3][3];
        A[0] = new int[] {1, 1, 0};
        A[1] = new int[] {1, 0, 1};
        A[2] = new int[] {0, 0, 0};

        A = flipAndInvertImage(A);

        for (int[] arr : A) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println();

        int[][] B = new int[4][4];
        B[0] = new int[] {1, 1, 0, 0};
        B[1] = new int[] {1, 0, 0, 1};
        B[2] = new int[] {0, 1, 1, 1};
        B[3] = new int[] {1, 0, 1, 0};

        B = flipAndInvertImage(B);

        for (int[] arr : B) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public static int[][] flipAndInvertImage(int[][] A) {
        // 边遍历边改
        int leftPtr, rightPtr, tmpInt;
        for (int[] tmp : A) {
            leftPtr = 0;
            rightPtr = tmp.length - 1;
            while (leftPtr < rightPtr) {
                tmpInt = tmp[rightPtr];
                tmpInt ^= 1;
                tmp[rightPtr--] = (tmp[leftPtr] ^= 1);
                tmp[leftPtr++] = tmpInt;
            }
            if (leftPtr == rightPtr) {
                tmp[leftPtr] ^= 1;
            }
        }
        return A;
    }

}
