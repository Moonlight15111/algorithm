package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 *
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *
 * @ClassName FindNumberOfLIS
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/20 10:19
 * @Version V1.0
 **/
public class FindNumberOfLIS {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7}, b = {2, 2, 2, 2, 2};

        System.out.println(findNumberOfLIS(a));
        System.out.println(findNumberOfLIS(b));
    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length, m = 0, ans = 0;
        // len 表示以nums[i]结尾的最长递增子序列的长度
        // cnt 表示以nums[i]结尾的最长递增子序列的个数
        int[] len = new int[n], cnt = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            m = Math.max(m, len[i]);
        }
        for (int i = 0; i < n; i++) {
            if (len[i] == m) {
                ans += cnt[i];
            }
        }
        return ans;
    }

}
