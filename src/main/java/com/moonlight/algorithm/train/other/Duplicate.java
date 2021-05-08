package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&tqId=11203&tab=answerKey&from=cyc_github
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input: {2, 3, 1, 0, 2, 5}  Output: 2
 *
 * @author Moonlight
 * @date 2021/5/8 17:58
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5}, b = {1, 2, 0, 1, 4, 4, 5}, c = {2, 1, 3, 1, 4};
        System.out.println(duplicate(a));
        System.out.println(duplicate(b));
        System.out.println(duplicate(c));
    }

    public static int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private static void swap(int[] nums, int num, int i) {
        int t = nums[num];
        nums[num] = nums[i];
        nums[i] = t;
    }

}
