package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 输入：nums = [5,2,3,1]  输出：[1,2,3,5]
 *
 * 输入：nums = [5,1,1,2,0,0]  输出：[0,0,1,1,2,5]
 *
 */
public class SortArray {

    public static void main(String[] args) {
        int[] a = {5, 2, 3, 1}, b = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(a)));
        System.out.println(Arrays.toString(sortArray(b)));
    }

    public static int[] sortArray(int[] nums) {
        buildHeap(nums);
        int len = nums.length;
        while (len > 0) {
            swap(nums, 0, len - 1);
            len--;
            headpify(nums, 0, len);
        }
        return nums;
    }

    private static void headpify(int[] nums, int i, int len) {
        int lc = 2 * i + 1;
        while (lc < len) {
            int largest = lc + 1 < len && nums[lc] < nums[lc + 1] ? lc + 1 : lc;
            largest = nums[i] > nums[largest] ? i : largest;
            if (largest == i) {
                break;
            }
            swap(nums, i, largest);
            i = largest;
            lc = 2 * i + 1;
        }
    }

    private static void buildHeap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
             int idx = i, pIdx = (idx - 1) / 2;
             while (nums[idx] > nums[pIdx]) {
                 swap(nums, idx, pIdx);
                 idx = pIdx;
                 pIdx = (idx - 1) / 2;
             }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

}
