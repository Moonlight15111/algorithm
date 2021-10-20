package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pairs-with-sum-lcci/
 *
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * 输入: nums = [5,6,5], target = 11 输出: [[5,6]]
 *
 * 输入: nums = [5,6,5,6], target = 11  输出: [[5,6],[5,6]]
 *
 */
public class PairSums {

    public static void main(String[] args) {
        int[] a = {5, 6, 5}, b = {5, 6, 5, 6};
        List<List<Integer>> lists = pairSums(a, 11);
        for (List<Integer> list : lists) {
            System.out.print(list + ", ");
        }
        System.out.println();
        lists = pairSums(b, 11);
        for (List<Integer> list : lists) {
            System.out.print(list + ", ");
        }
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, s;
        while (l < r) {
            s = nums[l] + nums[r];
            if (s > target) {
                r--;
            } else if (s < target) {
                l++;
            } else {
                list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                ans.add(list);

                l++;
                r--;
            }
        }
        return ans;
    }

}
