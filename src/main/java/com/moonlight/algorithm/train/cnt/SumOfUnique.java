package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/sum-of-unique-elements/
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * 输入：nums = [1,2,3,2]  输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 *
 * 输入：nums = [1,1,1,1,1]  输出：0
 * 解释：没有唯一元素，和为 0 。
 *
 * 输入：nums = [1,2,3,4,5]  输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * @ClassName SumOfUnique
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/6 12:30
 * @Version V1.0
 **/
public class SumOfUnique {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2}, b = {1, 1, 1, 1, 1}, c = {1, 2, 3, 4, 5};
        System.out.println(sumOfUnique(a));
        System.out.println(sumOfUnique(b));
        System.out.println(sumOfUnique(c));
    }

    public static int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int n : nums) {
            cnt[n]++;
        }
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (cnt[i] == 1) {
                ans += i;
            }
        }
        return ans;
    }

}
