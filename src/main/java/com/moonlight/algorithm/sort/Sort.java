package com.moonlight.algorithm.sort;

/**
 * @ClassName Sort
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/2 14:47
 * @Version V1.0
 **/
public interface Sort {

    void sort(int[] arr);

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    };
}
