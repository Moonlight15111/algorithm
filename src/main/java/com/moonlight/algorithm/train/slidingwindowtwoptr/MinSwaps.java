package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 *
 * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
 * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
 *    字符串是一个空字符串，或者
 *    字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 *    字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 * 你可以交换 任意 两个下标所对应的括号 任意 次数。
 * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
 *
 * 输入：s = "][]["  输出：1
 * 解释：交换下标 0 和下标 3 对应的括号，可以使字符串变成平衡字符串。
 * 最终字符串变成 "[[]]" 。
 *
 * 输入：s = "]]][[["  输出：2
 * 解释：执行下述操作可以使字符串变成平衡字符串：
 * - 交换下标 0 和下标 4 对应的括号，s = "[]][][" 。
 * - 交换下标 1 和下标 5 对应的括号，s = "[[][]]" 。
 * 最终字符串变成 "[[][]]" 。
 *
 * 输入：s = "[]"  输出：0
 * 解释：这个字符串已经是平衡字符串。
 *
 * @ClassName MinSwaps
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/10 12:13
 * @Version V1.0
 **/
public class MinSwaps {

    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
    }

    public static int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1, ans = 0;
        while (l < r) {
            int a = 0, b = 0;
            while (l < r) {
                if (chars[l] == '[') {
                    a++;
                } else {
                    a--;
                }
                if (a < 0) {
                    break;
                }
                l++;
            }
            while (l < r) {
                if (chars[r] == ']') {
                    b++;
                } else {
                    b--;
                }
                if (b < 0) {
                    break;
                }
                r--;
            }
            if (l < r) {
                char c = chars[l];
                chars[l] = chars[r];
                chars[r] = c;
                ans++;
            }
        }
        return ans;
    }

}
