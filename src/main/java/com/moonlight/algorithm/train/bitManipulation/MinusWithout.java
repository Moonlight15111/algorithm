package com.moonlight.algorithm.train.bitManipulation;

/**
 * 不用加减乘除实现减法
 * @ClassName MinusWithout
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/27 15:42
 * @Version V1.0
 **/
public class MinusWithout {

    public static void main(String[] args) {
        System.out.println(minus(1, 2));
        System.out.println(minus(12, 2));
    }

    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int add(int a, int b) {
        // 0 + 1 = 1，1 + 1 = 10，0 + 0 = 0  ===>  a + b  ===>  a ^ b
        // 考虑到进位 ===> 只有相同位均为 1 的时候下一位相加才会产生进位  ===> (a & b) << 1
        int x;
        while (b != 0) {
            // 无进位相加结果
            x = a ^ b;
            // 进位结果
            b = (a & b) << 1;
            a = x;
        }
        return a;
    }

}
