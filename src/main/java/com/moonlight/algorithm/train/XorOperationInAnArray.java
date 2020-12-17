package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * @author Moonlight
 * @date 2020/12/17 16:09
 */
public class XorOperationInAnArray {

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));

        System.out.println(xorOperation2222(5, 0));
        System.out.println(xorOperation2222(4, 3));
        System.out.println(xorOperation2222(1, 7));
        System.out.println(xorOperation2222(10, 5));
    }

    public static int xorOperation2222(int n, int start) {
        if (n == 0) {
            return 0;
        }
        int res = start;
        int i = 1;
        while (i < n) {
            res ^= (start + (2 * i));
            i++;
        }
        return res;
    }

    public static int xorOperation(int n, int start) {
        if (n == 0) {
            return 0;
        }
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= (start + (2 * i));
        }
        return res;
    }

}
