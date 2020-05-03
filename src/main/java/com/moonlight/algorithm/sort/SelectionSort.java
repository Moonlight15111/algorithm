package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName SelectionSort
 * @Description: 選擇排序。前一個元素和後一個元素進行大小比較，用變量min來記錄較小元素的下標，内循環結束后，將min與i進行交換，以此類推
 * @Author Moonlight
 * @Date 2020/5/1 23:27
 * @Version V1.0
 **/
public class SelectionSort implements Sort{

    public static void main(String[] args){
        Sort sort = new SelectionSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }

    public void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0, len = arr.length - 1; i < len; i++) {
            int min = i;

            for (int j = i + 1, length = arr.length ; j < length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            swap(arr, i, min);
        }
    }
}
