package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-target-indices-after-sorting-array/
 *
 * 给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
 * 目标下标 是一个满足 nums[i] == target 的下标 i 。
 * 将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i], target <= 100
 *
 * 输入：nums = [1,2,5,2,3], target = 2  输出：[1,2]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。 满足 nums[i] == 2 的下标是 1 和 2 。
 *
 * 输入：nums = [1,2,5,2,3], target = 3  输出：[3]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。  满足 nums[i] == 3 的下标是 3 。
 *
 * 输入：nums = [1,2,5,2,3], target = 5  输出：[4]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。  满足 nums[i] == 5 的下标是 4 。
 *
 * 输入：nums = [1,2,5,2,3], target = 4  输出：[]
 * 解释：nums 中不含值为 4 的元素。
 *
 * @ClassName TargetIndices
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/4 12:58
 * @Version V1.0
 **/
public class TargetIndices {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 2, 3};
        System.out.println(targetIndices(a, 2));
        System.out.println(targetIndices(a, 3));
        System.out.println(targetIndices(a, 5));
        System.out.println(targetIndices(a, 4));
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                ans.add(i);
//            }
//        }
        int lt = 0, eq = 0;
        for (int n : nums) {
            if (n < target) {
                lt++;
            }
            if (n == target) {
                eq++;
            }
        }
        for (int i = lt; i < lt + eq; i++) {
            ans.add(i);
        }
        return ans;
    }

}
