package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName MergeSort
 * @Description: 归并. 将数组分为两半，分别进行排序然后合并。合并时： 左边 i 位置小于 右边 j 位置，左边 i 移入help数组，左边 i 位置大于 右边 j 位置，右边 j 移入help数组，剩下的直接追加到help数组
 * @Author Moonlight
 * @Date 2020/5/3 14:35
 * @Version V1.0
 **/
public class MergeSort implements Sort {

    public static void main(String[] arg){
        Sort sort = new MergeSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
//        int[] arr = {1,4,7,8,3,6,9};
//        sort.sort(arr);
//        Const.print(arr);

//        int i = 1;
//        i = i++; // i = 1: temp = i(等号右边的i)  i = i + 1(等号右边的i)  i = temp(等号左边的i)
//        i = ++i; // i = 2: i = i + 1(等号右边的i) temp = i(等号右边的i) i = temp(等号左边的i)
//        int j = i++; // j = 1, i = 2 : temp = i   i = i + 1   j = temp
//        int k = i + ++i * i++; // k = 2 + 3 * 3 = 11, i = 4
//        System.out.println("i: " + i + "   j: " + j + "  k: " + k);
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while(i <= mid && j <= end) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for(int m = 0; m < temp.length; m++) {
            arr[start + m] = temp[m];
        }
    }

    private void merge(int[] arr){
        int mid = arr.length / 2;

        int i = 0, j = mid + 1, k = 0;

        int[] help = new int[arr.length];

        while (i <= mid && j < arr.length) {
            help[k++] = arr[i++] <= arr[j++] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            help[k++] = arr[i++];
        }
        while (j < arr.length) {
            help[k++] = arr[j++];
        }
        for (int h = 0; h < help.length; h++) {
            arr[h] = help[h];
        }
    }


}
