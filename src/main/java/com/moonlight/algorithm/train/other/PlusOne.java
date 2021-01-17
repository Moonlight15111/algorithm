package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/plus-one/
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * @ClassName PlusOne
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/17 17:54
 * @Version V1.0
 **/
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));

        System.out.println(Arrays.toString(plusOne222(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne222(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne222(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }
    
    public static int[] plusOne222(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int ca = digits[len - 1] + 1 > 9 ? 1 : 0;
        if (ca == 1) {
            digits[len - 1] = 0;
            for (int i = len - 2; i >= 0 ; i--) {
                if (digits[i] + ca > 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += ca;
                    ca = 0;
                    break;
                }
            }
            if (ca == 1) {
                int[] res = new int[len + 1];
                res[0] = 1;
                return res;
            } else {
                return digits;
            }
        }
        digits[len - 1] += 1;
        return digits;
    }

}
