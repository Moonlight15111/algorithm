package com.moonlight.algorithm.train.other;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *     'A' -> 1  'B' -> 2  ...  'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 例如，"11106" 可以映射为：
 *     "AAJF" ，将消息分组为 (1 1 10 6)
 *     "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 输入：s = "12"  输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 输入：s = "226" 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 输入：s = "0"   输出：0
 * 解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 *
 * 输入：s = "06"  输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * @author Moonlight
 * @date 2021/4/21 13:04
 */
public class DecodeWays {

    public static void main(String[] args) {
        // 2
        System.out.println(numDecodings("12") + ", " + numDecodings123("12"));
        // 3
        System.out.println(numDecodings("226") + ", " + numDecodings123("226"));
        // 0
        System.out.println(numDecodings("0") + ", " + numDecodings123("0"));
        // 0
        System.out.println(numDecodings("06") + ", " + numDecodings123("06"));
        // 4
        System.out.println(numDecodings("2611055971756562") + ", " + numDecodings123("2611055971756562"));
    }

    public static int dp(String s) {
        // todo dp
        return 0;
    }

    public static int numDecodings123(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        return process123(s.toCharArray(), 0, s.length(), cache);
    }

    private static int process123(char[] chars, int index, int length, int[] cache) {
        if (cache[index] != -1) {
            return cache[index];
        }
        if (index >= length) {
            cache[index] = 1;
            return 1;
        }
        // 0 只能等别人来组合它，单独的一个 0 没有意义
        if (chars[index] == '0') {
            cache[index] = 0;
            return 0;
        }
        int ans = process123(chars, index + 1, length, cache);
        if (index < length - 1) {
            if ((chars[index] == '1' && chars[index + 1] >= '0' && chars[index + 1] <= '9')
                    || (chars[index] == '2'&& chars[index + 1] >= '0' && chars[index + 1] < '7')) {
                ans += process123(chars, index + 2, length, cache);
            }
        }
        cache[index] = ans;
        return ans;
    }

    public static int numDecodings(String s) {
        // 递归百分之两百超时
        if (s.startsWith("0")) {
            return 0;
        }
        return process(s.toCharArray(), 0, s.length());
    }

    private static int process(char[] chars, int index, int length) {
        if (index >= length) {
            return 1;
        }
        // 0 只能等别人来组合它，单独的一个 0 没有意义
        if (chars[index] == '0') {
            return 0;
        }
        int ans = process(chars, index + 1, length);
        if (index < length - 1) {
            if ((chars[index] == '1' && chars[index + 1] >= '0' && chars[index + 1] <= '9')
                    || (chars[index] == '2'&& chars[index + 1] >= '0' && chars[index + 1] < '7')) {
                ans += process(chars, index + 2, length);
            }
        }
        return ans;
    }

}
