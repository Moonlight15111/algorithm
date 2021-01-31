package com.moonlight.algorithm.train.tree;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @ClassName MoveZeroes
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/31 18:52
 * @Version V1.0
 **/
public class MoveZeroes {

    public static void main(String[] args) {
        int[] num = {0, 1, 0, 3, 12};
        int[] nums = {1, 0};
        int[] nnn = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(num);
        moveZeroes(nums);
        moveZeroes(nnn);
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nnn));
    }

    public static void moveZeroes1231(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length, cur = 0, prev = 0;
        while (cur < length) {
            if (nums[cur] != 0) {
                nums[prev++] = nums[cur];
            }
            cur++;
        }
        for (int i = prev; i < length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0, j = 1, tmp; i < nums.length; i++) {
            if (nums[i] == 0 && j <= nums.length - 1) {
                while ((tmp = nums[j]) == 0) {
                    if (j >= nums.length - 1) {
                        return;
                    }
                    j++;
                }
                nums[i] = tmp;
                nums[j] = 0;
            } else {
                j++;
            }
        }
    }

}