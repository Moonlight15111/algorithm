package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-triangle-number/
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 输入: [2,2,3,4]  输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * @ClassName TriangleNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/6 13:43
 * @Version V1.0
 **/
public class TriangleNumber {

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4};
        System.out.println(triangleNumber(a));
    }

    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0, len = nums.length;
        for (int i = len - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

}
