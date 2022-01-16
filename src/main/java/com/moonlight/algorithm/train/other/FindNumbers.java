package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 *
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 * 输入：nums = [12,345,2,6,7896]  输出：2
 *
 * 输入：nums = [555,901,482,1771]  输出：1
 *
 * @ClassName FindNumbers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/16 11:17
 * @Version V1.0
 **/
public class FindNumbers {

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public static int findNumbers(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            if ((i >= 10 && i < 100) || (i > 999 && i < 10000) || i == 100000) {
                ans++;
            }
        }
        return ans;
    }

}
