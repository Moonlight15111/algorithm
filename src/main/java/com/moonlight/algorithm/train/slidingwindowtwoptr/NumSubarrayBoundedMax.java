package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/
 *
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 输入: A = [2, 1, 4, 3]  L = 2  R = 3    输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 *
 * @ClassName NumSubarrayBoundedMax
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/4 12:15
 * @Version V1.0
 **/
public class NumSubarrayBoundedMax {

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3}, b = {2, 9, 2, 5, 6};
        // 3
        System.out.println(numSubarrayBoundedMax(a, 2, 3));
        // 7
        System.out.println(numSubarrayBoundedMax(b, 2, 8));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, len = nums.length, cnt = 0;
        for (int l = 0, r = 0; r < len && l < len; r++) {
            if (nums[r] > right) {
                l = r + 1;
                cnt = 0;
                continue;
            }
            if (nums[r] < left) {
                ans += cnt;
                continue;
            }
            cnt = r - l + 1;
            ans += cnt;
        }
        return ans;
    }

}
