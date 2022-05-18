package com.moonlight.algorithm.train.search;

/**
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 *
 * 给你一个整数数组 nums ，该数组具有以下属性：
 *   nums.length == 2 * n.
 *   nums 包含 n + 1 个 不同的 元素
 *   nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 10 ^ 4
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 *
 * 输入：nums = [1,2,3,3]  输出：3
 *
 * 输入：nums = [2,1,2,5,3,2]  输出：2
 *
 * 输入：nums = [5,1,5,2,5,3,5,4]  输出：5
 *
 * @author Moonlight
 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public static int repeatedNTimes(int[] nums) {
//        int n = nums.length / 2;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//            if (e.getValue() == n) {
//                return e.getKey();
//            }
//        }
//        return -1;
        // 出现了n，即该数占据了一半，那么不管怎么排列，连续选出三个数，肯定有两个数是一样的
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[len - 1];
    }

}
