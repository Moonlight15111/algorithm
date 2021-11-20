package com.moonlight.algorithm.train.cnt;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/check-array-formation-through-concatenation/
 *
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 *
 *
 * 输入：arr = [85], pieces = [[85]]  输出：true
 *
 * 输入：arr = [15,88], pieces = [[88],[15]]  输出：true
 * 解释：依次连接 [15] 和 [88]
 *
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]  输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 *
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]  输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 *
 * 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]  输出：false
 *
 * @ClassName CanFormArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/20 11:29
 * @Version V1.0
 **/
public class CanFormArray {

    public static void main(String[] args) {
        int[] a = {85}, b = {15, 88}, c = {49, 18, 16}, d = {91, 4, 64, 78}, e = {1, 3, 5, 7};
        int[][] aa = {{85}}, bb = {{88}, {15}}, cc = {{16, 18, 49}}, dd = {{78}, {4, 64}, {91}}, ee = {{2, 4, 6, 8}};

        System.out.println(canFormArray(a, aa));
        System.out.println(canFormArray(b, bb));
        System.out.println(canFormArray(c, cc));
        System.out.println(canFormArray(d, dd));
        System.out.println(canFormArray(e, ee));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) {
            map.put(p[0], p);
        }

        for (int i = 0, key; i < arr.length;) {
            key = arr[i];
            if (map.containsKey(key)) {
                int[] p = map.get(key);
                for (int v : p) {
                    if (arr[i] == v) {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }

}
