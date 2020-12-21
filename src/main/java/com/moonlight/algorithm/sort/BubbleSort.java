package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName BubbleSort
 * @Description: 冒泡排序。比較相鄰的兩個數，如果第一個比第二個大，交換位置。
 * @Author Moonlight
 * @Date 2020/5/1 23:39
 * @Version V1.0
 **/
public class BubbleSort implements Sort{

    public static void main(String[] args){
        Sort sort = new BubbleSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }

    public void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 1 交换  1 2 交换  2 3 交换 .... length - 2  length - 1 交换
        for (int i = arr.length - 1; i >= 0; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
//        for (int i = 0, length = arr.length - 1; i < length; i++) {
//            for (int j = 0; j < length - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    swap(arr, j, j + 1);
//                }
//            }
//        }
    }
}
