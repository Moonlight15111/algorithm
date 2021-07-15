package com.moonlight.algorithm.train.string;

import java.util.Objects;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 输入: "Hello, my name is John"  输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * @author Moonlight
 * @date 2021/7/15 12:14
 */
public class CountSegments {

    public static void main(String[] args) {
        System.out.println(countSegments(""));
        System.out.println(countSegments("Hello, my name is John"));
    }

    public static int countSegments(String s) {
        int ans = 0;
        for (String sss : s.split(" ")) {
            if (!Objects.equals(sss, "")) {
                ans++;
            }
        }
        return ans;
    }

}
