package com.moonlight.algorithm.train.contest.biweeklycontest53;

/**
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * 子字符串 是一个字符串中连续的字符序列。
 *
 * 输入：s = "xyzzaz"  输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 *
 * 输入：s = "aababcabc"   输出：4
 * 解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
 * 好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
 *
 * 1 <= s.length <= 100
 * s 只包含小写英文字母。
 *
 * @ClassName CountGoodSubstrings
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/29 22:35
 * @Version V1.0
 **/
public class CountGoodSubstrings {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0, j, k, n = chars.length; i < n; i++) {
            j = i + 1;
            k = j + 1;
            if (j < n && k < n && chars[i] != chars[j] && chars[i] != chars[k] && chars[j] != chars[k]) {
                ans++;
            }
        }
        return ans;
    }

}
