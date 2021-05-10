package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/set-mismatch/
 * <p>
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 输入：nums = [1,2,2,4]  输出：[2,3]
 * <p>
 * 输入：nums = [1,1]   输出：[1,2]
 *
 * @author Moonlight
 * @date 2021/5/10 13:13
 */
public class FindErrorNums {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 4}, b = {1, 1}, c = {3, 2, 3, 4, 6, 5};
        System.out.println(Arrays.toString(helpArr(a)) + ", " + Arrays.toString(findErrorNums(a)));
        System.out.println(Arrays.toString(helpArr(b)) + ", " + Arrays.toString(findErrorNums(b)));
        System.out.println(Arrays.toString(helpArr(c)) + ", " + Arrays.toString(findErrorNums(c)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int t;
        for (int i = 0; i < nums.length; i++) {
            t = Math.abs(nums[i]) - 1;
            if (nums[t] < 0) {
                ans[0] = t + 1;
            } else {
                nums[t] = -nums[t];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }

    public static int[] helpArr(int[] nums) {
        int[] ans = new int[2];
        int[] help = new int[nums.length];

        for (int n : nums) {
            help[n - 1]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (help[i] > 1) {
                ans[0] = i + 1;
            }
            if (help[i] == 0) {
                ans[1] = i + 1;
            }
        }

        return ans;
    }

}
