package com.moonlight.algorithm.train.greedy;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/array-partition-i/
 *
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 *
 * 输入：nums = [1,4,3,2]   输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 *      1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 *      2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 *      3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 *      所以最大总和为 4
 *
 * 输入：nums = [6,2,6,5,1,2]  输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 *
 * @author Moonlight
 * @date 2021/5/8 11:57
 */
public class ArrayPairSumI {

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 2}, b = {6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(a));
        System.out.println(arrayPairSum(b));
    }

    public static int arrayPairSum(int[] nums) {
        // 因为是min(a, b)，所以每一个小的数都会牺牲一个比它大的数
        // 又因为是求最大总和，我们还是想尽可能拿大的数，但是牺牲又是不可避免的，所以就选择牺牲一个小一点的数
        // 即每次都想选大的，但是最大的不能选，因为是拿min(a, b)，所以退而求其次选第二大的
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

}