package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。
 * 比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * 输入：nums = [42,11,1,97]  输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * <p>
 * 输入：nums = [13,10,35,24,76]   输出：4
 *
 * @ClassName CountNicePairs
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/3 22:46
 * @Version V1.0
 **/
public class CountNicePairs {

    public static void main(String[] args) {
        int[] a = {42, 11, 1, 97}, b = {35, 13, 10, 24, 76};

        System.out.println(countNicePairs(a));
        System.out.println(countNicePairs(b));

        System.out.println(countNicePairs1231(a));
        System.out.println(countNicePairs1231(b));

    }

    public static int countNicePairs1231(int[] nums) {
        // 由 nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        // 可得 nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        // 则统计nums[i] - rev(nums[i])的值出现的次数，对于值相等的下标，两两组合就可以了
        long res = 0;

        Map<Long, Integer> map = new HashMap<>();
        for (int i : nums) {
            long key = (long) i - rev(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int n : map.values()) {
            res += (long) n * (n - 1) / 2;
        }

        return (int)(res % 1_000_000_007);
    }


    public static int countNicePairs(int[] nums) {
        // timeout
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isNicePair(nums[i], nums[j])) {
                    res++;
                    res %= 1_000_000_007;
                }
            }
        }
        return res;
    }

    public static boolean isNicePair(int i, int j) {
//        System.out.println("i = " + i + "  and  " + "j = " + j + " result: " + (i + rev(j) == j + rev(i)));
        return i + rev(j) == j + rev(i);
    }

    public static int rev(int i) {
        int res = 0;
        while (i != 0) {
            res = res * 10 + (i % 10);
            i /= 10;
        }
        return res;
    }

}
