package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName SmallSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/4 15:04
 * @Version V1.0
 **/
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        return process(arr, start, mid) + process(arr, mid + 1, end) + merge(arr, start, mid, end);
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0, smallSum = 0;

        while(i <= mid && j <= end) {
            smallSum += arr[i] < arr[j] ? (end - j + 1) * arr[i] : 0;
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
        return smallSum;
    }
}
