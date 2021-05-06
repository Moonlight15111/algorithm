package com.moonlight.algorithm.train.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 输入:nums = [1,1,1], k = 2    输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * @author Moonlight
 * @date 2021/5/6 16:49
 */
public class SubArraySumEqualsk {

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        System.out.println(preSumArray(a, 2) + ", " + preSumAndMap(a, 2));
    }

    public static int preSumAndMap(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            // nums 的某项 = 两个相邻前缀和的差: nums[x] = pre[x] - pre[x - 1]
            // nums 的 第 i 到 j 项 的和, nums[i...j] = pre[j] - pre[i - 1]
            // 所以如果 map 中存在 key 为「当前前缀和 - k」说明这个之前出现的前缀和，满足「当前前缀和 - 该前缀和 == k」
            // 那么说明 当前位置 i 到 该前缀位置 j 之间存在着连续和等于 k 的情况
            // 那么我们只要统计这种情况出现的次数即可
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static int preSumArray(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (presum[j + 1] - presum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

}