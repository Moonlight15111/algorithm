package com.moonlight.algorithm.train.sort;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，
 * 使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 *
 * 输入：nums = [3,4,5,2]  输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 *
 * 输入：nums = [1,5,4,5]  输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 *
 * 输入：nums = [3,7]  输出：12
 *
 * @ClassName MaxProduct
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/30 13:19
 * @Version V1.0
 **/
public class MaxProduct {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 2}, b = {1, 5, 4, 5}, c = {3, 7};
        System.out.println(heapSort(a) + ", " + maxProduct(a));
        System.out.println(heapSort(b) + ", " + maxProduct(b));
        System.out.println(heapSort(c) + ", " + maxProduct(c));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = 0, second = 0;

        for (int num : nums) {
            if (first < num) {
                second = first;
                first = num;
            } else if (second < num) {
                second = num;
            }
        }

        return (first - 1) * (second - 1);
    }

    public static int heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = 0, second = 0, len = nums.length;
        buildHeap(nums);
        first = nums[0];
        swap(nums, 0, len - 1);
        len--;
        heapify(nums, 0, len);
        second = nums[0];

        return (first - 1) * (second - 1);
    }

    private static void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        while (left < len) {
            int largest = left + 1 < len && nums[left] < nums[left + 1] ? left + 1 : left;
            largest = nums[i] > nums[largest] ? i : largest;
            if (i == largest) {
                break;
            }
            swap(nums, i, largest);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private static void buildHeap(int[] nums) {
        for (int i = 0, idx, pIdx; i < nums.length; i++) {
            idx = i;
            pIdx = (idx - 1) / 2;
            while (nums[idx] > nums[pIdx]) {
                swap(nums, idx, pIdx);
                idx = pIdx;
                pIdx = (idx - 1) / 2;
            }
        }
    }

    private static void swap(int[] nums, int idx, int pIdx) {
        int t = nums[idx];
        nums[idx] = nums[pIdx];
        nums[pIdx] = t;
    }

}
