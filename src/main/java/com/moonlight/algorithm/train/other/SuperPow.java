package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/super-pow/
 *
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 *
 * 输入：a = 2, b = [3]  输出：8
 *
 * 输入：a = 2, b = [1,0]  输出：1024
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]  输出：1
 *
 * 输入：a = 2147483647, b = [2,0,0]  输出：1198
 *
 * @ClassName SuperPow
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/5 11:07
 * @Version V1.0
 **/
public class SuperPow {

    public static void main(String[] args) {
        System.out.println(superPow(2, new int[]{3}));
        System.out.println(superPow(2, new int[]{1, 0}));
        System.out.println(superPow(1, new int[]{4, 3, 3, 8, 5, 2}));
        System.out.println(superPow(2147483647, new int[]{2, 0, 0}));
    }


    public static int superPow(int a, int[] b) {
        if (a == 1) {
            return 1;
        }
        return recursion(a, b, b.length - 1);
    }

    private static int recursion(int a, int[] b, int start) {
        if (start < 0) {
            return 1;
        }
        return pow(recursion(a, b, start - 1), 10) * pow(a, b[start]) % 1337;
    }

    private static int pow(int a, int b) {
        int res = 1;
        a %= 1337;
        while (b > 0) {
            res = res * a % 1337;
            b--;
        }
        return res;
    }

}
