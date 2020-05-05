package com.moonlight.algorithm;

/**
 * @ClassName Const
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/2 12:37
 * @Version V1.0
 **/
public class Const {

    public static int[] arr = {10, 2, 9, 1, 2, 3, 9, 8, 7};

    public static void print(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append(", ");
        }
        System.out.println(sb.toString());
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
