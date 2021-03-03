package com.moonlight.algorithm.train.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/advantage-shuffle/
 *
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 * 输入：A = [2,7,11,15], B = [1,10,4,11]   输出：[2,11,7,15]
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]  输出：[24,32,8,12]
 *
 * @author Moonlight
 * @date 2021/3/3 14:59
 */
public class AdvantageShuffle {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {1, 10, 4, 11};
        System.out.println(Arrays.toString(advantageCount(a, b)));
        int[] c = {12, 24, 8, 32};
        int[] d = {13, 25, 32, 11};
        System.out.println(Arrays.toString(advantageCount(c, d)));
        int[] e = {2, 0, 4, 1, 2};
        int[] f = {1, 3, 0, 0, 2};
        System.out.println(Arrays.toString(advantageCount(e, f)));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        // 找到A中恰好大于B的数, 找得到就将该数加入到结果中，找不到就把最小的放到结果集中
        // 田忌赛马
        Arrays.sort(A);

        List<Integer> list = new ArrayList<>();
        for (Integer a : A) {
            list.add(a);
        }

        int[] res = new int[A.length];
        for (int i = 0, j, length = B.length; i < length; i++) {
            j = binarySearch(list, B[i]);
            res[i] = list.remove(j);
        }
        return res;
    }

    public static int binarySearch(List<Integer> list, int i) {
        int left = 0, right = list.size() - 1, mid;

        if (list.get(left) > i || list.get(right) <= i) {
            return left;
        }

        while (left < right) {
            mid = left + (right - left) / 2;
            if (list.get(mid) <= i) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
