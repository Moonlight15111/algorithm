package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 输入：nums = [4,1,4,6]  输出：[1,6] 或 [6,1]
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]  输出：[2,10] 或 [10,2]
 *
 * @ClassName SingleNumbers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/10 0:22
 * @Version V1.0
 **/
public class SingleNumbers {

    public static void main(String[] args) {
        int[] a = {4, 1, 4, 6}, b = {1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(singleNumbers(a)));
        System.out.println(Arrays.toString(singleNumbers(b)));
    }

    public static int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int farLeftBit1 = xor & (-xor);
        int x = 0;
        for (int n : nums) {
            if ((n & farLeftBit1) != 0) {
                x ^= n;
            }
        }
        return new int[]{x, xor ^ x};
    }

}
