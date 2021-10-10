package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @ClassName Exchange
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/10 12:48
 * @Version V1.0
 **/
public class Exchange {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(a)));
    }

    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && (nums[l] & 1) == 1) {
                l++;
            }
            while (l < r && (nums[r] & 1) == 0) {
                r--;
            }
            if (l < r) {
                int x = nums[l];
                nums[l] = nums[r];
                nums[r] = x;
            }
        }
        return nums;
    }

}
