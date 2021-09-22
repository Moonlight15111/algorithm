package com.moonlight.algorithm.train.backtrack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 *
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 *
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 *
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] ints = floodFill(a, 1, 1, 2);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        backtrack(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void backtrack(int[][] image, int sr, int sc, int n, int o) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != o || o == n) {
            return;
        }
        image[sr][sc] = n;

        backtrack(image, sr, sc + 1, n, o);
        backtrack(image, sr, sc - 1, n, o);
        backtrack(image, sr + 1, sc, n, o);
        backtrack(image, sr - 1, sc, n, o);
    }

}
