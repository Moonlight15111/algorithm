package com.moonlight.algorithm.train.other;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 输入: nums = [1,2,3,1], k = 3   输出: true
 *
 * 输入: nums = [1,0,1,1], k = 1   输出: true
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2  输出: false
 *
 * @ClassName ContainsDuplicateII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/5 11:29
 * @Version V1.0
 **/
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1}, b = {1, 0, 1, 1}, c = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(a, 3));
        System.out.println(containsNearbyDuplicate(b, 1));
        System.out.println(containsNearbyDuplicate(c, 2));

        System.out.println(containsNearbyDuplicate123(a, 3));
        System.out.println(containsNearbyDuplicate123(b, 1));
        System.out.println(containsNearbyDuplicate123(c, 2));
    }

    public static boolean containsNearbyDuplicate123(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
