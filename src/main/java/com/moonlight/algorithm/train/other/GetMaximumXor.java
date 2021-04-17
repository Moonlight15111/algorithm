package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 给你一个 有序 数组 nums ，它由 n 个非负整数组成，同时给你一个整数 maximumBit 。你需要执行以下查询 n 次：
 * 找到一个非负整数 k < 2maximumBit ，使得 nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k 的结果 最大化 。k 是第 i 个查询的答案。
 * 从当前数组 nums 删除 最后 一个元素。
 * 请你返回一个数组 answer ，其中 answer[i]是第 i 个查询的结果
 *
 * 输入：nums = [0,1,1,3], maximumBit = 2
 * 输出：[0,3,2,3]
 * 解释：查询的答案如下：
 * 第一个查询：nums = [0,1,1,3]，k = 0，因为 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3 。
 * 第二个查询：nums = [0,1,1]，k = 3，因为 0 XOR 1 XOR 1 XOR 3 = 3 。
 * 第三个查询：nums = [0,1]，k = 2，因为 0 XOR 1 XOR 2 = 3 。
 * 第四个查询：nums = [0]，k = 3，因为 0 XOR 3 = 3 。
 *
 * 输入：nums = [2,3,4,7], maximumBit = 3
 * 输出：[5,2,6,5]
 * 解释：查询的答案如下：
 * 第一个查询：nums = [2,3,4,7]，k = 5，因为 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7。
 * 第二个查询：nums = [2,3,4]，k = 2，因为 2 XOR 3 XOR 4 XOR 2 = 7 。
 * 第三个查询：nums = [2,3]，k = 6，因为 2 XOR 3 XOR 6 = 7 。
 * 第四个查询：nums = [2]，k = 5，因为 2 XOR 5 = 7 。
 *
 * 输入：nums = [0,1,2,2,5,7], maximumBit = 3
 * 输出：[4,3,6,4,6,7]
 *
 * @ClassName GetMaximumXor
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/17 23:41
 * @Version V1.0
 **/
public class GetMaximumXor {

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 3}, b = {2, 3, 4, 7}, c = {0, 1, 2, 2, 5, 7};
        // [0,3,2,3]
        System.out.println(Arrays.toString(getMaximumXor1231(a, 2)));
        // [5,2,6,5]
        System.out.println(Arrays.toString(getMaximumXor1231(b, 3)));
        // [4,3,6,4,6,7]
        System.out.println(Arrays.toString(getMaximumXor1231(c, 3)));
    }

    public static int[] getMaximumXor1231(int[] nums, int maximumBit) {
        int[] xor = new int[nums.length];
        xor[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor[i] = nums[i] ^ xor[i - 1];
        }
        int[] res = new int[nums.length];
        for(int i = 0, n = nums.length; i < n; i++) {
            for(int j = 0; j < maximumBit; j++) {
                res[n - i - 1] += xor[i] & (1 << j) ^ (1 << j);
            }
        }
        return res;
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        // timeout
        int[] xor = new int[nums.length];
        xor[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor[i] = nums[i] ^ xor[i - 1];
        }
        int[] res = new int[nums.length];
        int len = 0, max, maxI;
        for (int i = xor.length - 1; i >= 0; i--) {
            max = 0;
            maxI = 0;
            for (int j = 0; j < Math.pow(2, maximumBit); j++) {
                max = Math.max(max, xor[i] ^ j);
                if (max == (xor[i] ^ j)) {
                    maxI = j;
                }
            }
            res[len++] = maxI;
        }
        return res;
    }

}
