package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/binary-number-with-alternating-bits/submissions/
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111
 * @author Moonlight
 * @date 2020/12/22 9:40
 */
public class HasAlternatingBits {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(3));
    }

    public static boolean hasAlternatingBits(int num) {
        // 找到最高有效位，统计有多少个有效位
        int count = 0;
        int temp = num;
        while (temp != 0) {
            temp >>= 1;
            count++;
        }
        // 在有效位内，两两匹配
        for (int i = 0; i < count; i++) {
            int a = (num & (1 << i)) == 0 ? 0 : 1;
            int b = (num & (1 << (i + 1))) == 0 ? 0 : 1;
            if (a == b) {
                return false;
            }
        }
        return true;
    }

}
