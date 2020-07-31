package com.moonlight.algorithm.train;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回〉
 *  原题：https://leetcode-cn.com/problems/counting-bits/
 *  示例：输入2，输出[0,1,1]
 * @author Moonlight
 * @date 2020/7/31 16:49
 */
public class CountBits {

    public static void main (String[] args) {
        System.out.println(Arrays.toString(countBits(7)));
    }

    public static int[] countBits(int number){
        if (number < 0) {
            return null;
        }

        int[] res = new int[number + 1];

        for (int i = 0; i <= number; i++) {
            res[i] = countNumberOne(i);
        }

        return res;
    }

    private static int countNumberOne(int num){
        int count = 0, farRightNumOne;
        while (num != 0) {
            farRightNumOne = getFarRightNumOne(num);
            count++;
            num ^= farRightNumOne;
        }
        return count;
    }

    private static int getFarRightNumOne (int num) {
        return num & (-num);
    }

}
