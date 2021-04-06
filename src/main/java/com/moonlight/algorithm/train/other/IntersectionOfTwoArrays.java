package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 说明：
 *   输出结果中的每个元素一定是唯一的。
 *   我们可以不考虑输出结果的顺序。
 *
 * @author Moonlight
 * @date 2021/4/6 13:27
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1}, b = {2, 2},
                c = {4, 9, 5}, d = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(a, b)));
        System.out.println(Arrays.toString(intersection(c, d)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int n : nums1) {
            if (exist(n, nums2)) {
                set.add(n);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int n : set) {
            res[i++] = n;
        }
        return res;
    }

    private static boolean exist(int n, int[] nums2) {
        int left = 0, right = nums2.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums2[mid] > n) {
                right = mid - 1;
            } else if (nums2[mid] < n) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
