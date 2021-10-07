package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 *
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 *
 * 输入：s = "ababa"  输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 *
 * 输入：s = "abb"  输出：2
 * 解释："abb" -> "bb" -> "".
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 *
 * 输入：s = "baabb"  输出：2
 * 解释："baabb" -> "b" -> "".
 *       先删除回文子序列 "baab"，然后再删除 "b"。
 *
 * @ClassName RemovePalindromeSub
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/7 13:16
 * @Version V1.0
 **/
public class RemovePalindromeSub {

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
        System.out.println(removePalindromeSub("abb"));
        System.out.println(removePalindromeSub("baabb"));
    }

    public static int removePalindromeSub(String s) {
        // 要刪除的是回文子序列 子序列 子序列
        return s == null || s.length() == 0 ? 0 : (new StringBuilder(s).reverse().toString().equals(s) ? 1 : 2);
    }

}
