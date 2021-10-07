package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
 *
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *     i != j
 *     0 <= i, j < arr.length
 *     arr[i] == 2 * arr[j]
 *
 * 输入：arr = [10,2,5,3]  输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 *
 * 输入：arr = [7,1,14,11]  输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 *
 * 输入：arr = [3,1,7,11]  输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 * @ClassName CheckIfExist
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/7 13:41
 * @Version V1.0
 **/
public class CheckIfExist {

    public static void main(String[] args) {
        int[] a = {10, 2, 5, 3}, b = {7, 1, 14, 11}, c = {3, 1, 7, 11};
        System.out.println(checkIfExist(a));
        System.out.println(checkIfExist(b));
        System.out.println(checkIfExist(c));
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int l = 0, n, len = arr.length, r = 0; l < len; l++) {
            n = 2 * arr[l];
            while (r < len && arr[r] < n) {
                r++;
            }
            if (r < len && r != l && n == arr[r]) {
                return true;
            }
            if (r >= len) {
                return false;
            }
        }
        return false;
    }

}
