package com.moonlight.algorithm.train.dp;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * 对于一个字符串数组String[]，想一种办法来找出该字符串数组中最长公共子串(大小写相同不算相等)
 * 如果不存在公共子串，返回空串
 *
 * 输入: strs = {"dog", "racecar", "car"}     输出: ""
 * 输入: strs = {"flower", "flow", "flight"}  输出: "fl"
 * 输入: strs = {"sorry", "hharrd", "rrxxy"}  输出: "rr"
 * @author Moonlight
 * @date 2021/5/6 13:27
 */
public class StringArrayLongsetSubString {

    public static void main(String[] args) {
        String[] a = {"dog", "racecar", "car"}, b = {"flower", "flow", "flight"}, c = {"sorry", "hharrd", "rrxxy"};
        System.out.println(longestSubString(a));
        System.out.println(longestSubString(b));
        System.out.println(longestSubString(c));
    }

    public static String longestSubString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = "";
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < str.length() - i + 1; j++) {
                    if (validate(str.substring(i, i + j), strs) && str.substring(i, i + j).length() > ans.length()) {
                        ans = str.substring(i, i + j);
                    }
                }
            }
        }
        return ans;
    }

    private static boolean validate(String substring, String[] strs) {
        if (substring.length() < 1) {
            return false;
        }
        for (String s : strs) {
            if (!s.contains(substring)) {
                return false;
            }
        }
        return true;
    }

}
