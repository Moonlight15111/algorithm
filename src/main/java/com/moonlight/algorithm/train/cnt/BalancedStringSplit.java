package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 * 输入：s = "RLRRLLRLRL"  输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 输入：s = "RLLLLRRRLR"  输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 输入：s = "LLLLRRRR"  输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *
 * 输入：s = "RLRRRLLRLL"  输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * @author Moonlight
 */
public class BalancedStringSplit {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        int cnt = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ans++;
            }
        }
        return ans;
    }

}