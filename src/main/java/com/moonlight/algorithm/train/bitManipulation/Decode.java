package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/decode-xored-array/
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * 输入：encoded = [1,2,3], first = 1          输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 *
 * 输入：encoded = [6,2,7,3], first = 4        输出：[4,2,0,7,4]
 *
 * @author Moonlight
 * @date 2021/2/19 10:13
 */
public class Decode {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(decode(arr, 1)));

        int[] arrrrr = {6, 2, 7, 3};
        System.out.println(Arrays.toString(decode(arrrrr, 4)));
    }

    public static int[] decode(int[] encoded, int first) {
        if (encoded == null || encoded.length == 0) {
            return encoded;
        }

        int[] res = new int[encoded.length + 1];
        res[0] = first;

        int index = 1, cur = first;

        for (int num : encoded) {
            res[index] = num ^ cur;
            cur = num ^ cur;
            index++;
        }

        return res;
    }

}