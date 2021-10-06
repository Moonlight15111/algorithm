package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/duplicate-zeros/
 *
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 输入：[1,0,2,3,0,4,5,0]  输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * 输入：[1,2,3]  输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 * @ClassName DuplicateZeros
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/6 14:13
 * @Version V1.0
 **/
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] a = {1, 0, 2, 3, 0, 4, 5, 0}, b = {1, 2, 3};
        duplicateZeros(a);
        duplicateZeros(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] != 0) {
                continue;
            }
            for (int j = len - 2; j > i; j--) {
                arr[j + 1] = arr[j];
            }
            arr[++i] = 0;
        }
    }

}
