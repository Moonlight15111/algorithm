package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 输入：s = "egg", t = "add"   输出：true
 *
 * 输入：s = "foo", t = "bar"   输出：false
 *
 * 输入：s = "paper", t = "title"  输出：true
 *
 * @ClassName IsomorphicStrings
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/5 11:06
 * @Version V1.0
 **/
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        // 每个字符是否都有一个与之相对应的唯一的映射
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (s.indexOf(sChars[i]) != t.indexOf(tChars[i])) {
                return false;
            }
        }
        return true;
    }

}
