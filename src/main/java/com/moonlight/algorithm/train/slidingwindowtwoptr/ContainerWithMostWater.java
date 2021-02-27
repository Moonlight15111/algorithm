package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 原题：https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]    输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 输入：height = [4,3,2,1,4]   输出：16
 *
 * 输入：height = [1,2,1]   输出：2
 *
 *
 * @ClassName ContainerWithMostWater
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/23 23:26
 * @Version V1.0
 **/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));

        int[] b = {4, 3, 2, 1, 4};
        System.out.println(maxArea(b));

        int[] c = {1, 2, 1};
        System.out.println(maxArea(c));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // 题目描述是脑瘫，其实想说的就是哪两个点能盛的水最多
        // 直接双指针卡住两头，然后根据宽度和矮的一端计算最多能盛多少水，每计算一次，移动一下矮的那一端
        int width = height.length - 1, leftPtr = 0, rightPtr = height.length - 1, res = Integer.MIN_VALUE;

        while (leftPtr < rightPtr) {
            if (height[leftPtr] < height[rightPtr]) {
                res = Math.max(res, height[leftPtr] * width);
                leftPtr++;
            } else {
                res = Math.max(res, height[rightPtr] * width);
                rightPtr--;
            }
            width--;
        }

        return res;
    }

}
