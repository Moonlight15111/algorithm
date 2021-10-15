package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/B1IidL/
 *
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *    arr.length >= 3
 *   存在 i（0 < i < arr.length - 1）使得：
 *      arr[0] < arr[1] < ... arr[i-1] < arr[i]
 *      arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *
 * 输入：arr = [0,1,0] 输出：1
 *
 * 输入：arr = [0,10,5,2]  输出：1
 *
 * 输入：arr = [3,4,5,1]  输出：2
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]  输出：2
 *
 */
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] a = {0, 1, 0}, b = {0, 10, 5, 2}, c = {3, 4, 5, 1}, d = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(peakIndexInMountainArray(a));
        System.out.println(peakIndexInMountainArray(b));
        System.out.println(peakIndexInMountainArray(c));
        System.out.println(peakIndexInMountainArray(d));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length, ans = Integer.MIN_VALUE;
        for (int i = 1; i <= len - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
