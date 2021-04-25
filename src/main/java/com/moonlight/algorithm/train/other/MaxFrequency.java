package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 * 输入：nums = [1,2,4], k = 5   输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 *       4 是数组中最高频元素，频数是 3 。
 *
 * 输入：nums = [1,4,8,13], k = 5  输出：2
 * 解释：存在多种最优解决方案：
 *       - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 *       - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 *       - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 *
 * 输入：nums = [3,9,6], k = 2   输出：1
 *
 * @author Moonlight
 * @date 2021/4/25 12:48
 */
public class MaxFrequency {

    public static void main(String[] args) {
        int[] a = {1, 2, 4}, b = {1, 4, 8, 13}, c = {3, 9, 6};
        // 3
        System.out.println(maxFrequency(a, 5));
        // 2
        System.out.println(maxFrequency(b, 5));
        // 1
        System.out.println(maxFrequency(c, 2));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, left = 0;
        long sum = 0;
        // 假设有一个窗口从 left 到 right，如果这个窗口中的数全部可以通过操作得到 r
        // 则: 窗口元素和值sum + k 必须要 >= num[right] * (right - left + 1)
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum + k < (long)nums[right] * (right - left + 1)) {
                sum -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }

}
