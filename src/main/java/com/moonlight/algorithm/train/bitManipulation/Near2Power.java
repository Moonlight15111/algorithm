package com.moonlight.algorithm.train.bitManipulation;

/**
 * 给定一个非负整数num，
 * 如何不用循环语句，
 * 返回>=num，并且离num最近的，2的某次方
 *
 * @ClassName Near2Power
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/20 20:21
 * @Version V1.0
 **/
public class Near2Power {

    public static void main(String[] args) {
        System.out.println(near2Power(13));
        System.out.println(near2Power(15));
    }

    public static int near2Power(int n) {
        if (n < 1) {
            return 1;
        }

        // 兼顾n正好是2的某次方，如果它正好是2的某次方就给它打散，不是也无所谓，反正下面都会打满 1
        n--;

        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n + 1;
    }

}
