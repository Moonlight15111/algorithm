package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 *
 * 给你两个数组，arr1 和 arr2，
 *    arr2 中的元素各不相同
 *    arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *   1. 1 <= arr1.length, arr2.length <= 1000
 *   2. 0 <= arr1[i], arr2[i] <= 1000
 *   3. arr2 中的元素 arr2[i] 各不相同
 *   4. arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * @ClassName RelativeSortArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/31 12:32
 * @Version V1.0
 **/
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, b = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(a, b)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : arr1) {
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
//        for (int i = 0, j = 0; i < arr2.length; i++) {
//            if (map.containsKey(arr2[i])) {
//                while (map.get(arr2[i]) > 0) {
//                    arr1[j++] = arr2[i];
//                    map.put(arr2[i], map.get(arr2[i]) - 1);
//                }
//                map.remove(arr2[i]);
//            }
//        }
        int[] cnt = new int[1001];
        for (int n : arr1) {
            cnt[n]++;
        }
        int idx = 0;
        int[] ans = new int[arr1.length];
        for (int i = 0, t; i < arr2.length; i++) {
            t = arr2[i];
            for (int j = 0; j < cnt[t]; j++) {
                ans[idx++] = t;
            }
            cnt[t] = 0;
        }
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                ans[idx++] = i;
            }
            cnt[i] = 0;
        }
        return ans;
    }

}
