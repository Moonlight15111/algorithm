package com.moonlight.algorithm.train.slidingwindowdoubleptr;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/3sum-closest/
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1    输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * @ClassName ThreeSumClosest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/25 22:45
 * @Version V1.0
 **/
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] a = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(a, 1));
        int[] b = {1, 1, 1, 0};
        System.out.println(threeSumClosest(b, -100));
        int[] c = {0, 2, 1, -3};
        System.out.println(threeSumClosest(c, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 排好序以后，每次固定一个数，去找另外两个数字
        // tmp < target 左指针右移，因为数组已经排好序了，左指针右移会让下一次的值更大，更接近target，右指针左移同理
        int leftPtr = 0, rightPtr = 0, length = nums.length, res = nums[0] + nums[1] + nums[2], tmp;

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            leftPtr = i + 1;
            rightPtr = length - 1;

            while (leftPtr < rightPtr) {
                tmp = nums[i] + nums[leftPtr] + nums[rightPtr];
                res = Math.abs(target - tmp) > Math.abs(target - res) ? res : tmp;
                if (tmp < target) {
                    leftPtr++;
                } else {
                    rightPtr--;
                }
            }
        }

        return res;
    }

}
