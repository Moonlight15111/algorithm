package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://www.lintcode.com/problem/181/
 *
 * 如果要将整数n转换为m，需要改变多少个bit位？n和m均为32位整数。
 *
 * 输入: n = 31, m = 14  输出:  2
 * 解释: (11111) -> (01110) 需要改变两个位.
 *
 * 输入: n = 1, m = 7   输出:  2
 * 解释: (001) -> (111) 需要更改两位
 *
 * @author Moonlight
 * @date 2021/4/29 17:54
 */
public class BitSwapRequired {

    public static void main(String[] args) {
        System.out.println(bitSwapRequired(31, 14));
        System.out.println(bitSwapRequired(1, 7));
    }

    public static int bitSwapRequired(int n, int m) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != (m & (1 << i))) {
                ans++;
            }
        }
        return ans;
    }

}