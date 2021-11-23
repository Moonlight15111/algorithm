package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 *
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 *
 * 输入：s = "ab", goal = "ba"  输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 *
 * 输入：s = "ab", goal = "ab"  输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 *
 * 输入：s = "aa", goal = "aa"  输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 *
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"  输出：true
 *
 * @author Moonlight
 */
public class BuddyStrings {

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] a = new int[26], b = new int[26];
        int dif = 0;
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            b[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                dif++;
            }
        }
        boolean same = false;
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
            if (a[i] > 1) {
                same = true;
            }
        }
        return dif == 2 || (dif == 0 && same);
    }

}
