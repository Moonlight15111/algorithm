package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题: https://leetcode-cn.com/problems/2-keys-keyboard/
 *
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *     Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 *     Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 *
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。
 * 输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 输入: 3    输出: 3
 * 解释:  最初, 我们只有一个字符 'A'。 第 1 步, 我们使用 Copy All 操作。
 *        第 2 步, 我们使用 Paste 操作来获得 'AA'。 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 *
 *
 * @author Moonlight
 * @date 2021/3/1 10:23
 */
public class TwoKeysKeyboard {

    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(12));
        System.out.println(minSteps(36));
    }



    public static int minSteps(int n) {
        // 当 n = 1 时，return 0
        if (n == 1) {
            return 0;
        }
        // 当 n = 2 时，需要copy all 一次，paste 一次，return 2
        // 当 n = 3 时，需要copy all 一次，paste 两次，return 3
        // 当 n = 4 时，需要copy all 一次，paste 三次，return 4 或 copy all 一次，paste 一次得到 'AA',再copy all 一次，paste 一次 return 4
        // 当 n = 5 时, 需要copy all 一次, paste 四次，return 5
        if (n <= 5) {
            return n;
        }
        // 当 n = 6 时，需要copy all 一次, paste 五次, return 6 或 copy all 一次，paste 一次得到 'AA',再copy all 一次，paste 两次 return 5
        // 当 n = 7 时，需要copy all 一次，paste 六次, return 7
        // 当 n = 8 时，需要copy all 一次，paste 七次，return 8 或
        //                  copy all 一次，paste 一次得到 'AA',再copy all 一次，paste 一次得到 'AAAA',再copy all 一次，paste 一次 return 6
        // 由上可知当n > 1 且为质数时，它需要的最少操作次数就是n
        //         非质数时,它需要的操作次数就是 x + y 且 n = x * y,如: 2 + 3 = 5, 6 = 2 * 3; 2 + 4 = 6, 2 * 4 = 8
        for (int i = 2; i <= n; i++) {
            if ((n % i) == 0) {
                return minSteps(n / i) + i;
            }
        }
        return n;
    }

}
