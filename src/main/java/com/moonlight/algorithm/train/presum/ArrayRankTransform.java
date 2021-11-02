package com.moonlight.algorithm.train.presum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/rank-transform-of-an-array/
 *
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *   序号从 1 开始编号。
 *   一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 *   每个数字的序号都应该尽可能地小。
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 *
 * 输入：arr = [40,10,20,30]  输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 *
 * 输入：arr = [100,100,100]  输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 *
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 *
 * @author Moonlight
 */
public class ArrayRankTransform {

    public static void main(String[] args) {
        int[] a = {40, 10, 20, 30}, b = {100, 100, 100}, c = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(arrayRankTransform(a)));
        System.out.println(Arrays.toString(arrayRankTransform(b)));
        System.out.println(Arrays.toString(arrayRankTransform(c)));
    }

    public static int[] arrayRankTransform(int[] arr) {
//        int min = 0, max = 0;
//        for (int n : arr) {
//            min = Math.min(min, n);
//            max = Math.max(max, n);
//        }
//        int[] cnt = new int[max - min + 1];
//        for (int n : arr) {
//            cnt[n - min]++;
//        }
//        int idx = 1;
//        for (int i = 0; i < cnt.length; i++) {
//            if (cnt[i] != 0) {
//                cnt[i] = idx++;
//            }
//        }
//        int[] ans = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            ans[i] = cnt[arr[i] - min];
//        }
//        return ans;
        Map<Integer, Integer> map = new HashMap<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int seq = 1;
        for (int n : clone) {
            if (map.containsKey(n)) {
                continue;
            }
            map.put(n, seq++);
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

}
