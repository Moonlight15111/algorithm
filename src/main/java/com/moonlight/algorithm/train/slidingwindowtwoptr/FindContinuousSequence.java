package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @ClassName FindContinuousSequence
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/11 21:41
 * @Version V1.0
 **/
public class FindContinuousSequence {

    public static void main(String[] args) {
        int[][] a = findContinuousSequence(9);
        int[][] b = findContinuousSequence(15);
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        for (int[] i : b) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 1, s = 0;
        while (l <= (target >>> 1)) {
            if (s < target) {
                s += r;
                r++;
            } else if (s > target) {
                s -= l;
                l++;
            } else {
                int[] a = new int[r - l];
                for (int i = l; i < r; i++) {
                    a[i - l] = i;
                }
                s -= l;
                l++;
                list.add(a);
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
