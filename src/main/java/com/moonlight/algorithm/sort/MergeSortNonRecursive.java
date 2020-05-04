package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName MergeSortNonRecursive
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/3 16:47
 * @Version V1.0
 **/
public class MergeSortNonRecursive implements Sort {

    public static void main(String[] arg){
        Sort sort = new MergeSortNonRecursive();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // mergeStep: 左组步长
        int length = arr.length, mergeStep = 1;
        while (mergeStep < length) {
            int left = 0;
            while (left < length) {
                // 左组的位置
                int mergePos = left + mergeStep - 1;
                if (mergePos >= length) {
                    break;
                }
                int min = Math.min(mergePos + mergeStep, length - 1);
                merge(arr, left, mergePos , min);
                left = min + 1;
            }
            if (mergeStep > length / 2) {
                break;
            }
            mergeStep <<= 1;
        }
    }

    private void merge(int[] arr, int left, int right, int rightBound) {
        int[] temp = new int[rightBound - left + 1];

        int i = left, j = right + 1, k = 0;

        while(i <= right && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= right) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }

        for(int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }
    }
}
