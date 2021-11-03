package com.moonlight.algorithm.train.cnt;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 *
 * 给你两个长度相同的整数数组 target 和 arr 。
 * 每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 *
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]  输出：true
 *
 * 输入：target = [7], arr = [7]  输出：true
 *
 * 输入：target = [1,12], arr = [12,1]  输出：true
 *
 * 输入：target = [3,7,9], arr = [3,7,11]  输出：false
 *
 * @author Moonlight
 */
public class CanBeEqual {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4}, b = {2, 4, 1, 3},
              c = {7}, d = {7},
              e = {1, 12}, f = {12, 1},
              g = {3, 7, 9}, h = {3, 7, 11};

        System.out.println(canBeEqual(a, b));
        System.out.println(canBeEqual(c, d));
        System.out.println(canBeEqual(e, f));
        System.out.println(canBeEqual(g, h));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (Arrays.equals(target, arr)) {
            return true;
        }
        int max = 0;
        for (int n : target) {
            max = Math.max(max, n);
        }
        int[] cnt = new int[max + 1];
        for (int n : target) {
            cnt[n]++;
        }
        for (int n : arr) {
            if (n >= cnt.length) {
                return false;
            }
            cnt[n]--;
        }
        for (int n : cnt) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }

}
