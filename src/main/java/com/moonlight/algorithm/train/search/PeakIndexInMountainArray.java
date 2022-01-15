package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 *   arr.length >= 3
 *   存在 i（0 < i < arr.length - 1）使得：
 *        arr[0] < arr[1] < ... arr[i-1] < arr[i]
 *        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足
 * arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 的下标 i 。
 *
 * 输入：arr = [0,1,0]  输出：1
 *
 * 输入：arr = [0,2,1,0]  输出：1
 *
 * 输入：arr = [0,10,5,2]  输出：1
 *
 * 输入：arr = [3,4,5,1]  输出：2
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]  输出：2
 *
 * @ClassName PeakIndexInMountainArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/15 11:29
 * @Version V1.0
 **/
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] a = {0, 1, 0}, b = {0, 2, 1, 0}, c = {0, 10, 5, 2}, d = {3, 4, 5, 1}, e = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(peakIndexInMountainArray(a) + ", " + binarySearch(a));
        System.out.println(peakIndexInMountainArray(b) + ", " + binarySearch(b));
        System.out.println(peakIndexInMountainArray(c) + ", " + binarySearch(c));
        System.out.println(peakIndexInMountainArray(d) + ", " + binarySearch(d));
        System.out.println(peakIndexInMountainArray(e) + ", " + binarySearch(e));
    }

    public static int binarySearch(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }
        int len = arr.length, ans = -1, left = 1, right = len - 2, mid = 0;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }
        int len = arr.length, ans = -1;
        for (int i = 1; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
