package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/sequential-digits/
 *
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 * 输出：low = 100, high = 300   输出：[123,234]
 *
 * 输出：low = 1000, high = 13000   输出：[1234,2345,3456,4567,5678,6789,12345]
 *
 * @author Moonlight
 * @date 2021/3/16 13:24
 */
public class SequentialDigits {

    public static void main(String[] args) {
        System.out.println(sequentialDigits(10, 100) + ", " + sequentialDigits12312(10, 100));
        System.out.println(sequentialDigits(100, 300) + ", " + sequentialDigits12312(100, 300));
    }

    public static List<Integer> sequentialDigits12312(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int num;
        for (int i = 1; i < 10; i++) {
            num = i;
            for (int j = i + 1; j < 10; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    res.add(num);
                }
                if (num >= high) {
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        // time out
        List<Integer> res = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            if (isSequentialDigits(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private static boolean isSequentialDigits(int num) {
        while (true) {
            int a = num % 10;
            int b = (num / 10) %10;
            if (a - b != 1) {
                return false;
            }
            num = num / 10;
            if (num < 10) {
                return true;
            }
        }
    }
}
