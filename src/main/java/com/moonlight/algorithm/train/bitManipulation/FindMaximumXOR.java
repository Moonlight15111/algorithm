package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * 你能在O(n)的时间解决这个问题吗？
 *
 *
 * @author Moonlight
 * @date 2020/12/24 9:45
 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        int[] arr = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(arr));

//        System.out.println(findMaximumXOR22222(arr));

        int[] arr2 = {1, 1, 5, 5, 7, 100};
        System.out.println(findMaximumXOR(arr2));

//        System.out.println(findMaximumXOR22222(arr2));
    }

    public static int findMaximumXOR22222(int[] nums) {
        int maxXor = 0, len = nums.length;


        return maxXor;
    }

    public static int findMaximumXOR(int[] nums) {
        int maxXor = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                maxXor = Math.max(maxXor, nums[i] ^ nums[j]);
            }
        }
        return maxXor;
    }

}