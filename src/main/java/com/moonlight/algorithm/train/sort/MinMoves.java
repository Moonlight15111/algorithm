package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 *
 * 输入: [1,2,3]   输出: 3
 * 解释： 只需要3次操作（注意每次操作会增加两个元素的值）：
 *        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * @author Moonlight
 * @date 2021/4/16 13:28
 */
public class MinMoves {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(minMoves(a));
    }

    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        // 最大值和最小值差值相加即可
        for (int i = nums.length - 1; i > 0; i--) {
            res += nums[i] - nums[0];
        }
        return res;
    }
}
