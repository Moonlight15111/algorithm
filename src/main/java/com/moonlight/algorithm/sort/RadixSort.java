package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

import java.util.Arrays;

/**
 * @ClassName RadixSort
 * @Description: 基数。类似计数排序，按数据的个位/十位/百位分别进行处理
 * @Author Moonlight
 * @Date 2020/5/4 3:14
 * @Version V1.0
 **/
public class RadixSort implements Sort {

    public static void main(String[] args) {
        Const.print(sort(new int[]{123, 321, 213, 132, 345, 654, 789}, 3));
    }

    @Override
    public void sort(int[] arr) { }

    public static int[] sort(int[] arr, int digits) {
        int[] result = new int[arr.length];
        int[] help = new int[10];


        for(int i=0; i < digits; i++) {
            int division = (int)Math.pow(10, i);
            for(int j = 0, length = arr.length; j < length; j++) {
                int num = arr[j] / division % 10;
                help[num]++;
            }

            for(int m = 1, length = help.length; m < length; m++) {
                help[m] = help[m] + help[m - 1];
            }

            for(int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--help[num]] = arr[n];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(help, 0);
        }

        return result;
    }
}
