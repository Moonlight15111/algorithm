package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n）
 * 可知至少存在一个重复的整数。假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 输入：nums = [1,3,4,2,2]   输出：2
 *
 * 输入：nums = [3,1,3,4,2]   输出：3
 *
 * 输入：nums = [1,1]    输出：1
 *
 * 输入：nums = [1,1,2]   输出：1
 *
 * @author Moonlight
 * @date 2021/3/5 9:33
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 2}, b = {3, 1, 3, 4, 2}, c = {1, 1}, d = {1, 1, 2};
        System.out.println(findDuplicate(a) + ", " + findDup(a) + ", " + find(a));
        System.out.println(findDuplicate(b) + ", " + findDup(b) + ", " + find(b));
        System.out.println(findDuplicate(c) + ", " + findDup(c) + ", " + find(c));
        System.out.println(findDuplicate(d) + ", " + findDup(d) + ", " + find(d));
    }

    public static int find(int[] nums) {
        int slowPtr = 0, fastPtr = 0;
        while (true) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[nums[fastPtr]];
            if (slowPtr == fastPtr) {
                break;
            }
        }
        slowPtr = 0;
        while (true) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
            if (slowPtr == fastPtr) {
                break;
            }
        }
        return slowPtr;
    }

    public static int findDup(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            if (++count[num] > 1) {
                return num;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int findDuplicate(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] ^ nums[j]) == 0) {
                    return nums[i];
                }
            }
        }
        return Integer.MIN_VALUE;
    }

}
