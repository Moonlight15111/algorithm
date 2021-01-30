package com.moonlight.algorithm.train.other;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个 n + 1 的数组 nums，数组中所有的数都在1 到 n 范围内，其中 n >= 1
 * 请找出数组中任意一个重复的数，但不能修改原数组
 *
 * 输入: nums: [2, 3, 5, 4, 3, 2, 6, 7]  输出: 2 或者 3
 *
 * 进阶：如果只能使用O（1）的额外空间，该怎么做呢？
 *
 * @author Moonlight
 * @date 2021/1/30 17:20
 */
public class FindDuplicateNum {

    public static int findDuplicateNum(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
        }
        return -1;
    }

}
