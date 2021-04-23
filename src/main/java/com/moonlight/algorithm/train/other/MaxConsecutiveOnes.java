package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * 输入：[1,1,0,1,1,1]    输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * @author Moonlight
 * @date 2021/4/23 13:26
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(a));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, ans = 0;
        for (int num : nums) {
            if (num == 1) {
                ++count;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        return Math.max(count, ans);
    }

}
