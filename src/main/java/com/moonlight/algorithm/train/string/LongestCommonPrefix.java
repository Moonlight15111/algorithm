package com.moonlight.algorithm.train.string;

import java.util.Objects;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]   输出："fl"
 *
 * @author Moonlight
 * @date 2021/1/16 12:00
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a", "ar"}));
    }

    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        String res = arr[0];
        for (int i = 1, j, length = arr.length; i < length; i++) {
            j = 0;
            for (;j < arr[i].length() && j < res.length(); j++) {
                if (res.charAt(j) != arr[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (Objects.equals(res, "")) {
                return res;
            }
        }
        return res;
    }

}
