package com.moonlight.algorithm.train.search;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]  输出：2.00000  解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]  输出：2.50000  解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]  输出：0.00000
 *
 * 输入：nums1 = [], nums2 = [1]  输出：1.00000
 *
 * 输入：nums1 = [2], nums2 = []  输出：2.00000
 *
 * @author Moonlight
 * @date 2021/3/18 14:15
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] aa = {1, 3}, bb = {2};
        System.out.println(findMedianSortedArrays(aa, bb));
        int[] a = {1, 2}, b = {3, 4};
        System.out.println(findMedianSortedArrays(a, b));
        int[] c = {0, 0}, d = {0, 0};
        System.out.println(findMedianSortedArrays(c, d));
        int[] e = {}, f = {1};
        System.out.println(findMedianSortedArrays(e, f));
        int[] g = {2}, h = {};
        System.out.println(findMedianSortedArrays(g, h));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] arr = new double[nums1.length + nums2.length];
        int index = 0;
        for (int i : nums1) {
            arr[index++] = i;
        }
        for (int i : nums2) {
            arr[index++] = i;
        }
        Arrays.sort(arr);
        int mid = arr.length / 2;
        if ((arr.length & 1) == 1) {
            return arr[mid];
        }
        return (arr[mid] + arr[mid - 1]) / 2;
    }

}
