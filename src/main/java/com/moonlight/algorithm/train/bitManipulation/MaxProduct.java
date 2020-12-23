package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * @author Moonlight
 * @date 2020/12/23 16:59
 */
public class MaxProduct {

    public static void main(String[] args) {
        String[] arr = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(arr));

        String[] arr22 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(maxProduct(arr22));

        String[] arr333 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(maxProduct(arr333));
    }

    public static int maxProduct121(String[] words) {
        //
        return 0;
    }

    public static int maxProduct(String[] words) {
        int max = 0;
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (noCommonLetters(words[i], words[j])) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    private static boolean noCommonLetters(String word, String word1) {
        for (char c : word.toCharArray()) {
            if (word1.indexOf(c) != -1) {
                return false;
            }
        }
        return true;
    }

}
