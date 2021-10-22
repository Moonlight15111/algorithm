package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 */
public class ConstructArr {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr(a)));
    }

    public static int[] constructArr(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int len = a.length;
        int[] left = new int[len], right = new int[len], ans = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

}
