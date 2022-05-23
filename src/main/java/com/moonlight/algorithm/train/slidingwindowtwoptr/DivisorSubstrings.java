package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
 *
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 *  子字符串长度为 k 。
 *  子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * 注意：
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 *
 * 1 <= num <= 109
 * 1 <= k <= num.length （将 num 视为字符串）
 *
 * 输入：num = 240, k = 2  输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 *
 * 输入：num = 430043, k = 2  输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 *
 * @author Moonlight
 */
public class DivisorSubstrings {

    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
        System.out.println(divisorSubstrings(430043, 2));
    }

    public static int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int n = numStr.length(), left = 0, right = 0, val = 0, ans = 0;
        while (right < n) {
            val = val * 10 + (numStr.charAt(right) - '0');
            if (right - left + 1 >= k) {
                if (val != 0 && num % val == 0) {
                    ans++;
                }
                val -= (Math.pow(10, k - 1) * (numStr.charAt(left) - '0'));
                left++;
            }
            right++;
        }
        return ans;
    }

}
