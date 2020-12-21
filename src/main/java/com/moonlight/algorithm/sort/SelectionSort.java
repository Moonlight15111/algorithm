package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName SelectionSort
 * @Description: 選擇排序。循环找出最小的数排到前面
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
        // 假设第 i 个位置为最小值，往前遍历，找到比 i 还小的数，然后和 i 交换
        for (int i = 0, len = arr.length - 1; i < len; i++) {
            int min = i;

            for (int j = i + 1, length = arr.length ; j < length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            swap(arr, i, min);
        }
    }
}
