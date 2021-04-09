package com.moonlight.algorithm.train.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author Moonlight
 * @date 2021/4/9 13:28
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1}, b = {2, 2}, c = {4, 9, 5}, d = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect123(a, b)));
        System.out.println(Arrays.toString(intersect123(c, d)));
    }

    public static int[] intersect123(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i++];
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mapA = new HashMap<>(), mapB = new HashMap<>();
        for (int n : nums1) {
            mapA.put(n, mapA.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            mapB.put(n, mapB.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                for (int i = 0; i < Math.min(mapA.get(key), mapB.get(key)); i++) {
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
