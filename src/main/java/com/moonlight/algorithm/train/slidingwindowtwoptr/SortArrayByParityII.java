package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 输入：[4,2,5,7]   输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * @ClassName SortArrayByParityII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/5 11:50
 * @Version V1.0
 **/
public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(a)));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        for (int i = 0, j = 1; i < nums.length; i += 2) {
            if ((nums[i] & 1) == 1) {
                while ((nums[j] & 1) == 1) {
                    j += 2;
                }
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }

}
