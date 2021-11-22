package com.moonlight.algorithm.train.design;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 *
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *   Solution(int[] nums) 使用整数数组 nums 初始化对象
 *   int[] reset() 重设数组到它的初始状态并返回
 *   int[] shuffle() 返回数组随机打乱后的结果
 *
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * @author Moonlight
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = new int[nums.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0, r; i < nums.length; i++) {
            r = random.nextInt(nums.length);
            while (set.contains(r)) {
                r = random.nextInt(nums.length);
            }
            res[i] = nums[r];
            set.add(r);
        }
        return res;
    }

}