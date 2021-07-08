package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 输入: [1,2,3,4]   输出: [24,12,8,6]
 *
 * @author Moonlight
 * @date 2021/7/7 17:56
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // 左右乘积
        int n = nums.length;
        int[] ans = new int[n], p = new int[n], s = new int[n];

        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = nums[i - 1] * p[i - 1];
        }
        s[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            s[i] = nums[i + 1] * s[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = p[i] * s[i];
        }

        return ans;
    }

}