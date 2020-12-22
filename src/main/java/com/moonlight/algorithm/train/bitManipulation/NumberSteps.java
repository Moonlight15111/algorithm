package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1
 *
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14 
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4 
 * Step 5) 4  是偶数，除 2 得到 2 
 * Step 6) 2  是偶数，除 2 得到 1 
 *
 * @author Moonlight
 * @date 2020/12/22 15:57
 */
public class NumberSteps {

    public static void main(String[] args) {
        System.out.println(numberSteps("1101"));
        System.out.println(numberSteps("01"));
        System.out.println(numberSteps("10"));
        System.out.println(numberSteps("1000"));
        System.out.println(numberSteps("1111011110000011100000110001011011110010111001010111110001"));
    }

    public static int numberSteps(String s) {
        // 先转成数字  再算    会超时
        long b;
        long num = 0;
        int length = s.length();
        String sub;
        for (int i = 0; i < length; i++) {
            sub = s.substring(i, i + 1);
            b = Integer.valueOf(sub);
            num += (b << (length - i - 1));
        }

        length = 0;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num += 1;
            }
            length++;
        }

        return length;
    }

}
