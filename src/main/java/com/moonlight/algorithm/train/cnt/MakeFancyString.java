package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/delete-characters-to-make-fancy-string/
 *
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 *
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 *
 * 输入：s = "leeetcode"  输出："leetcode"
 * 解释：从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。没有连续三个相同字符，所以返回 "leetcode" 。
 *
 * 输入：s = "aaabaaaa"  输出："aabaa"
 *
 * 输入：s = "aab"  输出："aab"
 *
 * @ClassName MakeFancyString
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/5 11:21
 * @Version V1.0
 **/
public class MakeFancyString {

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        System.out.println(makeFancyString("aab"));
    }

    public static String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (char c : chars) {
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == c) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt < 2) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

}
