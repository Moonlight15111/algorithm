package com.moonlight.algorithm.train.other;

/**
 * 原题：https://leetcode-cn.com/problems/monotonic-array/
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i] >= A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 输入：[1,2,2,3]    输出：true
 *
 * 输入：[6,5,4,4]    输出：true
 *
 * 输入：[1,3,2]      输出：false
 *
 * @ClassName IsMonotonicArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/28 17:42
 * @Version V1.0
 **/
public class IsMonotonicArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        System.out.println(isMonotonic(a));

        int[] b = {6, 5, 4, 4};
        System.out.println(isMonotonic(b));

        int[] c = {1, 3, 2};
        System.out.println(isMonotonic(c));
    }

    public static boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }

        boolean isDesc = false, isAsc = false;

        for (int i = 1, length = A.length; i < length; i++) {
            if (A[i] < A[i - 1]) {
                isAsc = true;
            } else if (A[i] > A[i - 1]) {
                isDesc = true;
            }
            if (isAsc && isDesc) {
                return false;
            }
        }

        return true;
    }

}
