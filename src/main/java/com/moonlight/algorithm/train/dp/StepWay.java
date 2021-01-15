package com.moonlight.algorithm.train.dp;

/**
 * 一个人可以一次往上迈1个台阶，也可以迈2个台阶
 * 返回这个人迈上N级台阶的方法数
 * @ClassName StepWay
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/15 21:28
 * @Version V1.0
 **/
public class StepWay {

    public static void main(String[] args) {
        System.out.println(stepWay(3));
    }

    public static int stepWay(int n) {
        if (n < 1) {
            return 0;
        }
        return process(n, 1);
    }

    private static int process(int n, int cur) {
        if (cur >= n) {
            return 1;
        }
        if (cur == n - 1) {
            return 2;
        }
        return process(n, cur + 1) + process(n, cur + 2);
    }

}
