package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * @author Moonlight
 * @date 2021/3/31 13:18
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0}, b = {2, 5, 6};
//        merge(a, 3, b, 3);
        merge12313(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

    public static void merge12313(int[] nums1, int m, int[] nums2, int n) {
        int[] help = new int[nums1.length];
        int i = 0, j = 0, index = 0;
        while (i < m || j < n) {
            int tmpI = i < m ? nums1[i] : Integer.MAX_VALUE;
            int tmpJ = j < n ? nums2[j] : Integer.MAX_VALUE;
            help[index++] = Math.min(tmpI, tmpJ);
            if (tmpI <= tmpJ) {
                i++;
            } else {
                j++;
            }
        }
        System.arraycopy(help, 0, nums1, 0, help.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 追加后归并
        for (int i = m, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
            nums1[i] = nums2[j];
        }
        mergeSort(nums1, 0, nums1.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] help = new int[end - start + 1];

        int leftPtr = start, rightPtr = mid + 1, index = 0;

        while (leftPtr <= mid && rightPtr <= end) {
            help[index++] = nums[leftPtr] <= nums[rightPtr] ? nums[leftPtr++] : nums[rightPtr++];
        }

        while (leftPtr <= mid) {
            help[index++] = nums[leftPtr++];
        }

        while (rightPtr <= end) {
            help[index++] = nums[rightPtr++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[start + i] = help[i];
        }
    }

}
