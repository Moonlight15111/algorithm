package com.moonlight.algorithm.train.bitManipulation;

/**
 * 不用加减乘除实现除法
 * @ClassName DivWithout
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/27 16:13
 * @Version V1.0
 **/
public class DivWithout {

    public static void main(String[] args) {
        System.out.println(div(-10, -2));
        System.out.println(div(-12, 2));
        System.out.println(div(24, 6));
    }

    public static int div(int a, int b) {
        int res = 0;
        int x = a < 0 ? add(~a, 1) : a;
        int y = b < 0 ? add(~b, 1) : b;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? add(~res, 1): res;
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
