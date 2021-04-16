package com.moonlight.algorithm.train.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/scramble-string/
 *
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 *   如果字符串的长度为 1 ，算法停止
 *   如果字符串的长度 > 1 ，执行下述步骤：
 *       在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 *       随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 *       在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * 输入：s1 = "great", s2 = "rgeat"  输出：true
 * 解释：s1 上可能发生的一种情形是：
 *       "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 *       "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 *       "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 *       "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 *       "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 *       "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 *       算法终止，结果字符串和 s2 相同，都是 "rgeat"
 *       这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 *
 * 输入：s1 = "abcde", s2 = "caebd"  输出：false
 *
 * 输入：s1 = "a", s2 = "a"   输出：true
 *
 * @author Moonlight
 * @date 2021/4/16 12:47
 */
public class ScrambleString {

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat") + ", " + isScramble1231("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd") + ", " + isScramble1231("abcde", "caebd"));
        System.out.println(isScramble("a", "a") + ", " + isScramble1231("a", "a"));
    }

    public static boolean dp(String s1, String s2) {
        return false;
    }

    public static boolean isScramble1231(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();
        return isScramble1231(s1, s2, map);
    }

    public static boolean isScramble1231(String s1, String s2, Map<String, Boolean> map) {
        if (map.containsKey(s1 + s2)) {
            return map.get(s1 + s2);
        }
        if (map.containsKey(s2 + s1)) {
            return map.get(s2 + s1);
        }
        if (s1.length() != s2.length()) {
            map.put(s1 + s2, false);
            map.put(s2 + s1, false);
            return false;
        }
        if (s2.equals(s1)) {
            map.put(s1 + s2, true);
            return true;
        }
        if (!check(s1, s2)) {
            map.put(s1 + s2, false);
            map.put(s2 + s1, false);
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            String a = s1.substring(0, i), b = s1.substring(i);
            String c = s2.substring(0, i), d = s2.substring(i);
            // 不交换
            if (isScramble1231(a, c, map) && isScramble1231(b, d, map)) {
                map.put(a + c, true);
                map.put(b + d, true);
                return true;
            }
            String e = s2.substring(0, s1.length() - i), f = s2.substring(s1.length() - i);
            // 交换
            if (isScramble1231(a, f, map) && isScramble1231(b, e, map)) {
                map.put(a + f, true);
                map.put(b + e, true);
                return true;
            }
        }
        map.put(s1 + s2, false);
        return false;
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s2.equals(s1)) {
            return true;
        }
        if (!check(s1, s2)) {
            return false;
        }
        // time out
        // 对于一个确定的位置 i ，s1可以分为 [0, i) [i, n)
        // s2可以分为: 1. 不交换, [0, i) [i, n)    2. 交换, [0, n - i) [n - i, n)
        // 我们只要比较 s1 的 [0, i) [i, n) 与 s2 的 [0, i) [i, n) 或者 [0, n - i) [n - i, n) 是否相等即可
        for (int i = 1; i < s1.length(); i++) {
            String a = s1.substring(0, i), b = s1.substring(i);
            String c = s2.substring(0, i), d = s2.substring(i);
            // 不交换
            if (isScramble(a, c) && isScramble(b, d)) {
                return true;
            }
            String e = s2.substring(0, s1.length() - i), f = s2.substring(s1.length() - i);
            // 交换
            if (isScramble(a, f) && isScramble(b, e)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(String s1, String s2) {
        int[] a = new int[26], b = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

}
