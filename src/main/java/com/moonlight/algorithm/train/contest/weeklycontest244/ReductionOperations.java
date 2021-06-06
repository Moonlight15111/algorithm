package com.moonlight.algorithm.train.contest.weeklycontest244;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
 * 找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
 * 找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
 * 将 nums[i] 减少到 nextLargest 。
 * 返回使 nums 中的所有元素相等的操作次数。
 *
 * 输入：nums = [5,1,3]
 * 输出：3
 * 解释：需要 3 次操作使 nums 中的所有元素相等：
 * 1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
 * 2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
 * 3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 * 解释：nums 中的所有元素已经是相等的。
 *
 * 输入：nums = [1,1,2,2,3]
 * 输出：4
 * 解释：需要 4 次操作使 nums 中的所有元素相等：
 * 1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
 * 2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。
 * 3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。
 * 4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
 *
 * @ClassName ReductionOperations
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/6 11:33
 * @Version V1.0
 **/
public class ReductionOperations {

    public static void main(String[] args) {
        int[] a = {5, 1, 3}, b = {1, 1, 1}, c = {1, 1, 2, 2, 3};
        System.out.println(reductionOperations(a));
        System.out.println(reductionOperations(b));
        System.out.println(reductionOperations(c));
    }

    public static int reductionOperations(int[] nums) {
        int[] count = new int[50001];
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 50000; i > 0; i--) {
            if (count[i] > 0) {
                ans += sum;
                sum += count[i];
            }
        }
        return ans;
    }

}
