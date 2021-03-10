package com.moonlight.algorithm.train.backtrack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 *
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3的x次方 ，我们称这个整数 y 是三的幂。
 *
 * 输入：n = 12    输出：true    解释：12 = 3 的 1 次方 + 3 的 2 次方
 *
 * 输入：n = 91    输出：true    解释：91 = 3 的 0 次方 + 3 的 2 次方 + 3 的 4 次方
 *
 * 输入：n = 21    输出：false
 *
 * @author Moonlight
 * @date 2021/3/10 14:20
 */
public class CheckPowersOfThree {

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12) + ", " + checkPowersOfThree1312(12));
        System.out.println(checkPowersOfThree(91) + ", " + checkPowersOfThree1312(91));
        System.out.println(checkPowersOfThree(21) + ", " + checkPowersOfThree1312(21));
        System.out.println(checkPowersOfThree(1) + ", " + checkPowersOfThree1312(1));
    }

    public static boolean checkPowersOfThree1312(int n) {
        return n < 2 || (n % 3 != 2 && checkPowersOfThree1312(n / 3));
    }

    public static boolean checkPowersOfThree(int n) {
        return backtrack(0, 0, n);
    }

    public static boolean backtrack(int index, int sum, int n) {
        if (sum == n) {
            return true;
        }
        for (int i = index; sum + (int)Math.pow(3, i) <= n; i++) {
            if ((n - sum) / 3 < i) {
                return false;
            }
            if (backtrack(i + 1, sum + (int)Math.pow(3, i), n)) {
                return true;
            }
        }
        return false;
    }

}
