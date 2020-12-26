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

    public void sort22(int[] arr) {
        int step = 1;
        int len = arr.length;
        while (step < len) {
            int left = 0;
            while (left < step) {
                int mid = left + step - 1;
                if (mid >= step) {
                    break;
                }
                int right = Math.min(mid + step, len - 1);
                merge(arr, left, mid, right);
                left = right + 1;
            }
            if (step > (len / 2)) {
                break;
            }
            step <<= 1;
        }
    }
}
