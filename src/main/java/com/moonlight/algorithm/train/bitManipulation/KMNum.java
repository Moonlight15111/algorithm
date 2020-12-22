package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 一个数组中有一个数出现了K次，其他数都出现了M次
 * M > 1 且 K < M  求出现了K次的数
 *
 * @ClassName KMNum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/22 21:48
 * @Version V1.0
 **/
public class KMNum {

    public static void main(String[] args) {
        int[] arr = {2, 2, 8, 8, 8, 8, 3, 3, 3, 3, 5, 5, 5 ,5};
        System.out.println(findK(arr, 2, 4));

        int[] arr222 = {4, 4, 4, 8, 8, 8, 8, 8, 8, 8, 8, 8, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5 ,5, 5, 5, 5, 5, 5,
        27, 27, 27, 27, 27, 27, 27, 27, 27, 15, 15, 15, 15, 15, 15, 15, 15, 15};
        System.out.println(findK(arr222, 3, 9));
    }

    public static int findK(int[] arr, int k, int m) {
        int[] help = new int[32];
        Arrays.fill(help, 0);

        int tmp;
        for (int value : arr) {
            tmp = value;
            for (int j = 0; j < 32; j++) {
                if ((tmp & (1 << j)) != 0) {
                    help[j] = help[j] + 1;
                }
            }
        }

        tmp = 0;
        for (int i = 0; i < 32; i++) {
            if (help[i] != 0 && help[i] % m != 0) {
                tmp |= (1 << i);
            }
        }

        return tmp;
    }

}
