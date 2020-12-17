package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/power-of-two/submissions/
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * @author Moonlight
 * @date 2020/12/17 18:54
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(13));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }

    public static boolean isPowerOfTwo(int n) {
        // x & (x - 1)：去掉二进制位中最右边的1 (如果有的话)
//        return n > 0 && (n & (n - 1)) == 0;
        return n > 0 && (n & -n) == n;
    }

}
