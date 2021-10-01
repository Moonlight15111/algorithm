package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,3]  输出: 2
 *
 * 输入: [0,1,2,3,4,5,6,7,9]  输出: 8
 *
 * @ClassName MissingNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/1 13:54
 * @Version V1.0
 **/
public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {0, 1, 3}, b = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(a));
        System.out.println(missingNumber(b));
    }

    public static int missingNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (ans != num) {
                break;
            } else {
                ans++;
            }
        }
        return ans;
    }

}
