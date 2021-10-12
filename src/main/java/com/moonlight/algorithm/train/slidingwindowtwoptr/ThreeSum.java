package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/1fGaJU/
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且 不重复 的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]  输出：[[-1,-1,2],[-1,0,1]]
 *
 * 输入：nums = []  输出：[]
 *
 * 输入：nums = [0] 输出：[]
 *
 * @ClassName ThreeSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/12 21:07
 * @Version V1.0
 **/
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4}, b = {1, -1, -1, 0}, c = {-2, 0, 1, 1, 2};
        List<List<Integer>> lists = threeSum(a);
        for (List<Integer> list : lists) {
            System.out.print(list);
        }
        System.out.println();
        lists = threeSum(b);
        for (List<Integer> list : lists) {
            System.out.print(list);
        }
        System.out.println();
        lists = threeSum(c);
        for (List<Integer> list : lists) {
            System.out.print(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0, s; i < len; i++) {
            int l = i + 1, r = len - 1, t = -nums[i];
            while (l < r) {
                s = nums[l] + nums[r];
                if (s == t) {
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (s < t) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }

}
