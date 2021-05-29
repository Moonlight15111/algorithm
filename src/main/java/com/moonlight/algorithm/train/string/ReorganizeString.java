package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/reorganize-string/
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 输入: S = "aab"   输出: "aba"
 *
 * 输入: S = "aaab"  输出: ""
 *
 * @author Moonlight
 * @date 2021/5/27 17:25
 */
public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        // 词频统计
        // 如果某个数超过了 s 的一半，那么必然不可行
        // 找出出现次数最多的字符，如果超过了长度的一半，直接return
        // 否则就随便排位置，只要能将出现次数最多的字符给间隔开就好
        int[] help = new int[26];
        char[] chars = s.toCharArray();
        int n = chars.length, limit = n + 1 >>> 1, max = 0, maxChar = 0;

        for (char c : chars) {
            help[c - 'a']++;
            if (help[c - 'a'] > max) {
                maxChar = c - 'a';
                max = help[maxChar];
                if (max > limit) {
                    return "";
                }
            }
        }

        char[] ans = new char[n];

        int index = 0;
        while (help[maxChar]-- > 0) {
            ans[index] = (char)(maxChar + 'a');
            index += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (help[i]-- > 0) {
                if (index >= n) {
                    index = 1;
                }
                ans[index] = (char)(i + 'a');
                index += 2;
            }
        }

        return new String(ans);
    }

}
