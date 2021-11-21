package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/second-largest-digit-in-a-string/
 *
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 *   1 <= s.length <= 500
 *   s 只包含小写英文字母和（或）数字。
 *
 * 输入：s = "dfa12321afd"  输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 *
 * 输入：s = "abc1111"  输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 * @ClassName SecondHighest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/21 12:33
 * @Version V1.0
 **/
public class SecondHighest {

    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
        System.out.println(secondHighest("abc1111"));
        System.out.println(secondHighest("xyz"));
        System.out.println(secondHighest("ck077"));
    }

    public static int secondHighest(String s) {
        int first = -1, ans = -1;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                continue;
            }
            if (first == -1) {
                first = c - '0';
            } else if (c - '0' > first) {
                ans = first;
                first = c - '0';
            } else if (c - '0' < first && c - '0' > ans) {
                ans = c - '0';
            }
        }
        return ans;
    }

}
