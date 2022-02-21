package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]  输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 *
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]  输出：5
 *
 * @author Moonlight
 */
public class FindLength {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        if (Arrays.equals(nums1, nums2)) {
            return nums1.length;
        }
        int ans = 0, n = nums1.length, m = nums2.length, limit, tmpAns;
        for (int i = 0; i < n; i++) {
            limit = Math.min(m, n - i);
            tmpAns = maxLen(nums1, i, nums2, 0, limit);
            ans = Math.max(tmpAns, ans);
        }
        for (int i = 0; i < m; i++) {
            limit = Math.min(n, m - i);
            tmpAns = maxLen(nums1, 0, nums2, i, limit);
            ans = Math.max(tmpAns, ans);
        }
        return ans;
    }

    private static int maxLen(int[] nums1, int n, int[] nums2, int m, int limit) {
        int cnt = 0, max = 0;
        for (int i = 0; i < limit; i++) {
            if (nums1[n + i] == nums2[m + i]) {
                cnt++;
            } else if (cnt > 0) {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        return cnt > 0 ? Math.max(cnt, max) : max;
    }

}
