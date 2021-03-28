package com.moonlight.algorithm.train.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-different-integers-in-a-string/submissions/
 *
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。
 * 注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
 * <p>
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * <p>
 * 输入：word = "leet1234code234"
 * 输出：2
 * <p>
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 *
 * @ClassName NumDifferentIntegers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/28 10:30
 * @Version V1.0
 **/
public class NumDifferentIntegers {

    public static void main(String[] args) {
        String a = "a123bc34d8ef34",
                b = "leet1234code234",
                c = "a1b01c001",
                d = "002come02and123",
                e = "035985750011523523129774573439111590559325";
        // 3
        System.out.println(numDifferentIntegers(a));
        // 2
        System.out.println(numDifferentIntegers(b));
        // 1
        System.out.println(numDifferentIntegers(c));
        // 2
        System.out.println(numDifferentIntegers(d));
        // 1
        System.out.println(numDifferentIntegers(e));
    }

    public static int numDifferentIntegers(String word) {
        // 找出每一串数字，并去除前导零，塞到set中
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (validate(word.charAt(i))) {
                builder.append(word.charAt(i));
            } else {
                if (builder.length() > 0) {
                    while (builder.charAt(0) == '0' && builder.length() > 1) {
                        builder.deleteCharAt(0);
                    }
                    set.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
        }
        if (builder.length() > 0) {
            while (builder.charAt(0) == '0' && builder.length() > 1) {
                builder.deleteCharAt(0);
            }
            set.add(builder.toString());
        }

        return set.size();
    }

    public static boolean validate(char c) {
        return c >= '0' && c <= '9';
    }

}
