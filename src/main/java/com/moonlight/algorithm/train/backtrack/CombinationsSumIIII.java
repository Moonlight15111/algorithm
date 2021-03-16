package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 数组M=[1,2,3,4,5,6,15,20,30,40,50,...]
 * 求和=N的组合，不限制组内个数
 * @author Moonlight
 * @date 2021/3/16 10:08
 */
public class CombinationsSumIIII {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 10, 15, 20, 30, 40, 50};
        System.out.println(process(a, 20));
    }

    public static List<List<Integer>> process(int[] arr, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        Arrays.sort(arr);
        backtrack(0, 0, n, arr, new ArrayList<Integer>(), res);
        return res;
    }

    private static void backtrack(int index, int sum, int target, int[] arr, ArrayList<Integer> path, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                path.add(arr[i]);
                backtrack(i + 1, sum + arr[i], target, arr, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}
