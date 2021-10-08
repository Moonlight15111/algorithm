package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 *
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 *    选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 *    选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 *    前缀和后缀在字符串中任意位置都不能有交集。
 *    前缀和后缀包含的所有字符都要相同。
 *    同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 *
 * 输入：s = "ca"  输出：2
 * 解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
 *
 * 输入：s = "cabaabac"
 * 输出：0
 * 解释：最优操作序列为：
 * - 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
 * - 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
 *
 * 输入：s = "aabccabba"
 * 输出：3
 * 解释：最优操作序列为：
 * - 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
 * - 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
 *
 * @ClassName MinimumLength
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/8 22:05
 * @Version V1.0
 **/
public class MinimumLength {

    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    public static int minimumLength(String s) {
        if (s.length() < 2 || s.charAt(0) != s.charAt(s.length() - 1)) {
            return s.length();
        }
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r && chars[l] == chars[r]) {
            while (l < r && chars[l] == chars[l + 1]) {
                l++;
            }
            while (l < r && chars[r] == chars[r - 1]) {
                r--;
            }
            l++;
            r--;
        }
        return Math.max(r - l + 1, 0);
    }

}
