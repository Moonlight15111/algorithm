package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 *
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 *   |a - x| < |b - x| 或者 |a - x| == |b - x| 且 a < b
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 * @ClassName FindClosestElements
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/15 19:42
 * @Version V1.0
 **/
public class FindClosestElements {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5}, b = {0, 1, 2, 3, 3, 4, 7, 7, 8};
        System.out.println(findClosestElements(a, 4, 3));
        System.out.println(findClosestElements(a, 4, -1));
        System.out.println(findClosestElements(b, 3, 5));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if (k == arr.length) {
            for (int i : arr) {
                ans.add(i);
            }
            return ans;
        }
        // 只需要K个元素，则表示需要移除 N - K 个元素，又因为数组本身就已经排好序了
        // 所以只要找到最左边符合要求的数，然后往后取K个值就可以了
        int n = arr.length, lPtr = 0, rPtr = n - 1, delCnt = n - k;
        while (delCnt > 0) {
            if (Math.abs(arr[lPtr] - x) > Math.abs(arr[rPtr] - x)) {
                lPtr++;
            } else {
                rPtr--;
            }
            delCnt--;
        }
        for (int i = lPtr; i < lPtr + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

}
