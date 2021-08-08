package com.moonlight.algorithm.train.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * @ClassName FizzBuzz
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/8 13:55
 * @Version V1.0
 **/
public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb;
        for (int i = 1; i <= n; i++) {
            sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
