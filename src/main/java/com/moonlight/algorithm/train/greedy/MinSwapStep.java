package com.moonlight.algorithm.train.greedy;

/**
 * 一个字符串中只有两种字符'G'和'B'，想让所有的G都放在左侧，所有的B都放在右侧
 * 或者所有的B都放在左侧，所有的G都放在右侧
 * 但是只能在相邻字符之间进行交换操作，请问请问至少需要交换几次，
 *
 * @ClassName MinSwapStep
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/20 20:51
 * @Version V1.0
 **/
public class MinSwapStep {

    public static void main(String[] args) {
        System.out.println(minStep("BBGGGBGBBG"));
    }

    public static int minStep(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int gIndex = 0, bIndex = 0, gStep = 0, bStep = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') {
                gStep += i - gIndex;
                gIndex++;
            } else {
                bStep += i - bIndex;
                bIndex++;
            }
        }
        return Math.min(gStep, bStep);
    }

}
