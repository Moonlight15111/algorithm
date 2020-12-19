package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/find-the-difference/
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母
 * 输入：s = "", t = "y"
 * 输出："y"
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * @author Moonlight
 * @date 2020/12/19 9:36
 */
public class FindTheDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("", "y"));
        System.out.println(findTheDifference("ae", "aea"));
    }

    public static char findTheDifference(String s, String t) {
//        char[] chars = s.toCharArray();
//        char[] array = t.toCharArray();
//        int xor = 0;
//        for (int c : chars) {
//            xor ^= c;
//        }
//        for (int c : array) {
//            xor ^= c;
//        }
        char xor = t.charAt(t.length() - 1);
        for (int i = 0, len = s.length(); i < len; i++) {
            xor ^= s.charAt(i) ^ t.charAt(i);
        }
        return xor;
    }

}
