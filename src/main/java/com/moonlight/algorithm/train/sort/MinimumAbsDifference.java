package com.moonlight.algorithm.train.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference/
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 输入：arr = [4,2,1,3]  输出：[[1,2],[2,3],[3,4]]
 *
 * 输入：arr = [1,3,6,10,15]  输出：[[1,3]]
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]  输出：[[-14,-10],[19,23],[23,27]]
 *
 * @ClassName MinimumAbsDifference
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/31 12:44
 * @Version V1.0
 **/
public class MinimumAbsDifference {

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 3}, b = {1, 3, 6, 10, 15}, c = {3, 8, -10, 23, 19, -4, -14, 27}, d = {40, 11, 26, 27, -20};
        List<List<Integer>> listList = opt(a);
        for (List<Integer> list : listList) {
            System.out.print(list + ", ");
        }

        System.out.println();

        listList = opt(b);
        for (List<Integer> list : listList) {
            System.out.print(list + ", ");
        }

        System.out.println();

        listList = opt(c);
        for (List<Integer> list : listList) {
            System.out.print(list + ", ");
        }

        System.out.println();

        listList = opt(d);
        for (List<Integer> list : listList) {
            System.out.print(list + ", ");
        }
    }

    public static List<List<Integer>> opt(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return ans;
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) < min) {
                min = arr[i] - arr[i - 1];
                ans.clear();
            } else if (Math.abs(arr[i] - arr[i - 1]) > min) {
                continue;
            }
            ans.add(Arrays.asList(arr[i - 1], arr[i]));
        }
        return ans;
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return ans;
        }
        Arrays.sort(arr);
        int min = Math.abs(arr[1] - arr[0]);
        ans.add(Arrays.asList(arr[0], arr[1]));
        for (int i = 2; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) < min) {
                min = arr[i] - arr[i - 1];
                ans.clear();
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (Math.abs(arr[i] - arr[i - 1]) == min) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }

}
