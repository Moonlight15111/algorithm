package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 * 输入：s = "hello"   输出："holle"
 *
 * 输入：s = "leetcode"  输出："leotcede"
 *
 * @ClassName ReverseVowels
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/4 11:44
 * @Version V1.0
 **/
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        int len = s.length(), l = 0, r = len - 1;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < len && vowels.indexOf(chars[l]) == -1) {
                l++;
            }
            while (r > 0 && vowels.indexOf(chars[r]) == -1) {
                r--;
            }
            if (l < r) {
                swap(l, r, chars);
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    public static void swap(int l, int r, char[] arr) {
        char a = arr[l];
        arr[l] = arr[r];
        arr[r] = a;
    }

}
