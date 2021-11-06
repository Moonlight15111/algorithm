package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/determine-if-string-halves-are-alike/
 * <p>
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
 * 注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s = "book"  输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * <p>
 * 输入：s = "textbook"  输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * <p>
 * 输入：s = "MerryChristmas"  输出：false
 * <p>
 * 输入：s = "AbCdEfGh"  输出：true
 *
 * @ClassName HalvesAreAlike
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/6 12:19
 * @Version V1.0
 **/
public class HalvesAreAlike {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book") + ", " + cnt("book"));
        System.out.println(halvesAreAlike("textbook") + ", " + cnt("textbook"));
        System.out.println(halvesAreAlike("MerryChristmas") + ", " + cnt("MerryChristmas"));
        System.out.println(halvesAreAlike("AbCdEfGh") + ", " + cnt("AbCdEfGh"));
    }

    public static boolean cnt(String s) {
        int[] cnt = new int[26];
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            cnt[c - 'a']++;
        }
        s = s.toLowerCase();
        return cnt(s, cnt, 0, s.length() / 2) == cnt(s, cnt, s.length() / 2, s.length());
    }

    public static int cnt(String s, int[] cnt, int start, int end) {
        int c = 0;
        for (int i = start; i < end; i++) {
            c += cnt[s.charAt(i) - 'a'];
        }
        return c;
    }

    public static boolean halvesAreAlike(String s) {
        String are = "aeiouAEIOU";
        int len = s.length(), a = 0, b = 0;
        for (int i = 0; i < len / 2; i++) {
            if (are.indexOf(s.charAt(i)) != -1) {
                a++;
            }
        }
        for (int i = len / 2; i < len; i++) {
            if (are.indexOf(s.charAt(i)) != -1) {
                b++;
            }
        }
        return a == b;
    }

}
