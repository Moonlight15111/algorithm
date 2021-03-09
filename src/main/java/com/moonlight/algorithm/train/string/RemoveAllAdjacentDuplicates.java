package com.moonlight.algorithm.train.string;

import java.util.Objects;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 输入："abbaca"    输出："ca"
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * @author Moonlight
 * @date 2021/3/9 12:09
 */
public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca") + ",  " + removeDuplicates123("abbaca"));
        System.out.println(removeDuplicates("aabbccddeeff") + ",  " + removeDuplicates123("aabbccddeeff"));
    }

    public static String removeDuplicates123(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (res.length() > 0 && res.charAt(res.length() - 1) == c) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String removeDuplicates(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 1, len = s.length(); i < len;) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s = s.substring(0, i - 1) + s.substring(i + 1, len);
                i = 1;
                len = s.length();
            } else {
                i++;
            }
        }
        return s;
    }

}
