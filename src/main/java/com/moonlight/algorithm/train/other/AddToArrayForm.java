package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/add-to-array-form-of-integer/
 *
 * 整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 *
 * 输入：num = [1,2,0,0], k = 34  输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 输入：num = [2,7,4], k = 181  输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 输入：num = [2,1,5], k = 806  输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * @author Moonlight
 */
public class AddToArrayForm {

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = num.length - 1; i >= 0 || k > 0; i--, k /= 10) {
            if (i >= 0) {
                k += num[i];
            }
            ans.add(k % 10);
        }
        Collections.reverse(ans);
        return ans;
    }

}