package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName InsertionSort
 * @Description: 插入排序。第i個數與它前面的數進行比較，如果大於則交換位置。
 * @Author Moonlight
 * @Date 2020/5/1 23:10
 * @Version V1.0
 **/
public class InsertionSort implements Sort{

    public static void main(String[] args){
        Sort sort = new InsertionSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }

    public void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1, length = arr.length; i < length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

}
