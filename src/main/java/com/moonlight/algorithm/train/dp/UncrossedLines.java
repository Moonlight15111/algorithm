package com.moonlight.algorithm.train.dp;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/uncrossed-lines/
 * <p>
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 * <p>
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]    输出：2
 * <p>
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]   输出：3
 * <p>
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]    输出：2
 *
 * @author Moonlight
 * @date 2021/5/21 13:07
 */
public class UncrossedLines {

    public static void main(String[] args) {
        int[] a = {1, 4, 2}, b = {1, 2, 4};
        int[] c = {2, 5, 1, 2, 5}, d = {10, 5, 2, 1, 5, 2};
        int[] e = {1, 3, 7, 1, 7, 5}, f = {1, 9, 2, 5, 1};

        System.out.println(maxUncrossedLines(a, b));
        System.out.println(maxUncrossedLines(c, d));
        System.out.println(maxUncrossedLines(e, f));
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
