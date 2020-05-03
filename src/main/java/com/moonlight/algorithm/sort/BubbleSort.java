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

        for (int i = 0, length = arr.length - 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
