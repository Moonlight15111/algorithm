package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 给定一个数组，请将数组中的数。奇数放在奇数下标，偶数放在偶数下标
 * @ClassName OddEvenNumArr
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/28 21:07
 * @Version V1.0
 **/
public class OddEvenNumArr {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddEvenNumArr(new int[]{9, 4, 2, 7, 8, 9, 10})));
    }

    public static int[] oddEvenNumArr(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int even = 0, odd = 1, index = arr.length - 1;
        int tmp;
        while (odd < arr.length && even < arr.length) {
            tmp = arr[index];
            if ((arr[index] & 1) == 0) {
                arr[index] = arr[even];
                arr[even] = tmp;
                even += 2;
            } else {
                arr[index] = arr[odd];
                arr[odd] = tmp;
                odd += 2;
            }
        }
        return arr;
    }

}
