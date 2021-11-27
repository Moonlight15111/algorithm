package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。
 * 例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 *
 * 输入：s = "0100"  输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 *
 * 输入：s = "10"  输出：0
 * 解释：s 已经是交替字符串。
 *
 * 输入：s = "1111"  输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 *
 * @ClassName MinimumChanges
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/27 11:31
 * @Version V1.0
 **/
public class MinimumChanges {

    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));
    }

    public static int minOperations(String s) {
        int one = 0, zero = 0;
        char cur = '0';
        for (char c : s.toCharArray()) {
            if (c == cur) {
                one++;
            } else {
                zero++;
            }
            cur = cur == '0' ? '1' : '0';
        }
        return Math.min(one, zero);
    }

}
