package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *   arr.length >= 3
 *   在 0 < i < arr.length - 1 条件下，存在 i 使得：
 *      arr[0] < arr[1] < ... arr[i-1] < arr[i]
 *      arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 输入：arr = [2,1]  输出：false
 *
 * 输入：arr = [3,5,5]  输出：false
 *
 * 输入：arr = [0,3,2,1] 输出：true
 *
 * @ClassName ValidMountainArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/2 12:10
 * @Version V1.0
 **/
public class ValidMountainArray {

    public static void main(String[] args) {
        int[] a = {2, 1}, b = {3, 5, 5}, c = {0, 3, 2, 1};
        System.out.println(validMountainArray(a));
        System.out.println(validMountainArray(b));
        System.out.println(validMountainArray(c));
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = 0, right = arr.length - 1;
        while (left < right && arr[left + 1] > arr[left]) {
            left++;
        }
        while (right > 0 && arr[right - 1] > arr[right]) {
            right--;
        }
        return left == right && left != 0 && right != arr.length - 1;
    }

}
