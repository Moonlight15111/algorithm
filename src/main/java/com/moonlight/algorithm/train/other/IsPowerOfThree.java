package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/power-of-three/
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * @ClassName IsPowerOfThree
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/7 21:15
 * @Version V1.0
 **/
public class IsPowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(45));
    }

    public static boolean isPowerOfThree(int n) {
//        找出数字 n 是否是数字 b 的幂的一个简单方法是，n % b 只要余数为 0，就一直将 n 除以 b
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
