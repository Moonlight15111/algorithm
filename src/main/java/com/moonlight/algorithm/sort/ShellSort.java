package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName ShellSort
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/3 21:46
 * @Version V1.0
 **/
public class ShellSort implements Sort {

    public static void main(String[] args){
        Sort sort = new ShellSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }
    @Override
    public void sort(int[] arr) {
        int length = arr.length, h = 1;

        while (h <= arr.length / 3)  {
            h = 3 * h + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j > gap - 1 && arr[j] < arr[j - gap]; j -= gap) {
                    swap(arr, j, j - gap);
                }
            }
        }
    }
}
