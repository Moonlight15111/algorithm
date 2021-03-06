package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]   输出: 6
 *
 *
 * @author Moonlight
 * @date 2021/3/6 17:14
 */
public class VolumeOfHistogramlcci {

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1}, b = {4,2,0,3,2,5};
        System.out.println(trap(a) + ", " + trap123(a));
        System.out.println(trap(b) + ", " + trap123(b));
    }

    public static int trap123(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        // 假设现在来到位置 x, 它左边最高的为 i，右边最高的为j, 则 x 能装的最多水 = min(i, j) - x
        int res = 0, len = height.length, leftPtr = 0, rightPtr = len - 1, leftMax = height[leftPtr], rightMax = height[rightPtr];

        while (leftPtr < rightPtr) {
            if (leftMax > rightMax) {
                res += rightMax - height[rightPtr--];
                rightMax = Math.max(rightMax, height[rightPtr]);
            } else {
                res += leftMax - height[leftPtr++];
                leftMax = Math.max(leftMax, height[leftPtr]);
            }
        }

        return res;
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        // 假设现在来到位置 x, 它左边最高的为 i，右边最高的为j, 则 x 能装的最多水 = min(i, j) - x
        int leftMax, rightMax, res = 0, len = height.length;
        for (int i = 0; i < len; i++) {
            leftMax = 0;
            rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < len; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

}
