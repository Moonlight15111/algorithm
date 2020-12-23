package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/integer-replacement/
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 *
 * @author Moonlight
 * @date 2020/12/23 9:11
 */
public class IntegerReplacement {

    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(65535));
        System.out.println(integerReplacement(2147483647));
    }

    public static int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        // 偶数直接位移就好，奇数就要考虑是减 1 好 还是加 1 好
        // 如果奇数是以 10 结尾 或者 为 3 的时候选择 - 1 其他以 11 结尾的选择 + 1
        // 因为要求的是变换成 1   所以争取每一步都消去一个 1 才是最好的
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                // Int MaxVal 会溢出
                n >>>= 1;
            } else {
                if ((n & 2) == 0 || n == 3) {
                    n -= 1;
                } else {
                    n += 1;
                }
            }
            count++;
        }
        return count;
    }

}
