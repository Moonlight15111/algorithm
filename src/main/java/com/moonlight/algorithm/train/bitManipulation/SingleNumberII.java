package com.moonlight.algorithm.train.bitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 输入：nums = [3,4,3,3]   输出：4
 *
 * 输入：nums = [9,1,7,9,7,9,7]  输出：1
 *
 * @ClassName SingleNumberII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/10 0:35
 * @Version V1.0
 **/
public class SingleNumberII {

    public static void main(String[] args) {
        int[] a = {3, 4, 3, 3}, b = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber1231(a));
        System.out.println(singleNumber1231(b));
    }

    public static int singleNumber1231(int[] nums) {
        int[] help = new int[32];
        for (int n : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                if ((n & bitMask) != 0) {
                    help[i]++;
                }
                bitMask <<= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res ^= help[i] % 3;
        }
        return res;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

}
