package com.moonlight.algorithm.train.contest.weeklycontest240;

/**
 * 给你两个 非递增 的整数数组 nums1​和 nums2​，数组下标均 从 0 开始 计数。
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
 * 如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 * <p>
 * 输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]  输出：2
 * 解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * <p>
 * 输入：nums1 = [2,2,2], nums2 = [10,10,1]  输出：1
 * 解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
 * 最大距离是 1 ，对应下标对 (0,1) 。
 * <p>
 * 输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]  输出：2
 * 解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * <p>
 * 输入：nums1 = [5,4], nums2 = [3,2]  输出：0
 * 解释：不存在有效下标对，所以返回 0 。
 * <p>
 * 1 <= nums1.length <= 105
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 105
 * nums1 和 nums2 都是 非递增 数组
 *
 * @ClassName MaxDistance
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/9 11:12
 * @Version V1.0
 **/
public class MaxDistance {

    public static void main(String[] args) {
        int[] a = {55, 30, 5, 4, 2}, b = {100, 20, 10, 10, 5};
        int[] c = {2, 2, 2}, d = {10, 10, 1};
        int[] e = {30, 29, 19, 5}, f = {25, 25, 25, 25, 25};
        int[] g = {5, 4}, h = {3, 2};
        // 2    1    2    0
        System.out.println(search(a, b) + ", " + maxDistance(a, b));
        System.out.println(search(c, d) + ", " + maxDistance(c, d));
        System.out.println(search(e, f) + ", " + maxDistance(e, f));
        System.out.println(search(g, h) + ", " + maxDistance(g, h));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, ans = 0;
        while (i < nums1.length && j < nums2.length) {
            if (i <= j && nums1[i] <= nums2[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                if (nums1[i] > nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    public static int search(int[] nums1, int[] nums2) {
        // timeout
        int n = nums1.length, m = nums2.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums1[i];
            for (int j = i; j < m; j++) {
                int y = nums2[j];
                if (x > y) {
                    break;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

}
