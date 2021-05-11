package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/decode-xored-permutation/submissions/
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 * 输入：encoded = [3,1]  输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 *
 * 输入：encoded = [6,5,4,6]  输出：[2,4,1,5,3]
 *
 * @author Moonlight
 * @date 2021/5/11 12:43
 */
public class DecodeXoredPermutation {

    public static void main(String[] args) {
        int[] a = {3, 1}, b = {6, 5, 4, 6};
        System.out.println(Arrays.toString(decode(a)));
        System.out.println(Arrays.toString(decode(b)));
    }

    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        // 为了得到原始数组 perm，应该首先得到数组 perm 的第一个元素
        // 如果能得到数组 perm 的全部元素的异或运算结果，以及数组 perm 除了perm[0] 以外的全部元素的异或运算结果，
        // 即可得到 perm[0] 的值
        // 由于数组 perm 是前 nn 个正整数的排列，因此数组 perm 的全部元素的异或运算结果即为从 1 到 n 的全部正整数的异或运算结果。
        // 又因为encoded[i] = perm[i] XOR perm[i + 1] 可以推出 encoded[i + 2] = perm[i + 2] XOR perm[i + 3]
        // 那么 encoded 所有下标为奇数的元素的异或运算结果即为数组 perm 除了 perm[0] 以外的全部元素的异或运算结果
        int nXor = 0;
        for (int i = 1; i <= n; i++) {
            nXor ^= i;
        }
        int oddXor = 0;
        for (int i = 1; i < n; i += 2) {
            oddXor ^= encoded[i];
        }
        ans[0] = nXor ^ oddXor;
        for (int i = 0; i < n - 1; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }

}