package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName CountingSort
 * @Description: 计数排序
 * @Author Moonlight
 * @Date 2020/5/4 2:36
 * @Version V1.0
 **/
public class CountingSort implements Sort {

    public static void main(String[] arg){
        CountingSort sort = new CountingSort(new int[15]);
//        sort.sort(Const.arr);
//        Const.print(Const.arr);
        Const.print(sort.sort(Const.arr, sort.help));
    }

    private int[] help;

    public CountingSort(int[] help){
        this.help = help;
    }

    @Override
    public void sort(int[] arr) {
        // 不稳定
        for (int value : arr) {
            this.help[value] += 1;
        }
        int j = 0;
        for (int i = 0, length = this.help.length; i < length; i++) {
            int count = this.help[i];
            while (count > 0) {
                arr[j++] = i;
                count--;
            }
        }
    }

    public int[] sort(int[] arr, int[] help) {
        int[] result = new int[arr.length];
        // 稳定
        for (int value : arr) {
            help[value] += 1;
        }
        for (int i = 1, length = help.length; i < length; i++) {
            help[i] = help[i] + help[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (help[arr[i]] > 0) {
                result[--help[arr[i]]] = arr[i];
            }
        }
        return result;
    }
}
