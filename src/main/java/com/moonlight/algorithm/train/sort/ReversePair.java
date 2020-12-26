package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 *
 * 逆序对问题。
 * 对于一个包含N个非负整数的数组A[0..n]，如果有i < j，且A[ i ]>A[ j ]，则称(A[ i] ,A[ j] )为数组A中的一个逆序对。
 * 例如，数组（3，1，4，5，2）的逆序对有(3,1),(3,2),(4,2),(5,2)，共4个。
 *
 * @ClassName ReversePair
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/26 11:55
 * @Version V1.0
 **/
public class ReversePair {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        System.out.println(reversePair(arr));
    }

    public static int reversePair(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) / 2);

        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];

        int leftP = mid, rightP = right, len = tmp.length - 1, res = 0;

        while (leftP >= left && rightP > mid) {
            res += arr[leftP] > arr[rightP] ? rightP - mid : 0;
            tmp[len--] = arr[leftP] > arr[rightP] ? arr[leftP--] : arr[rightP--];
        }

        while (leftP >= left) {
            tmp[len--] = arr[leftP--];
        }

        while (rightP > mid) {
            tmp[len--] = arr[rightP--];
        }

        len = tmp.length;
        for (int i = 0; i < len; i++) {
            arr[left + i] = tmp[i];
        }

        return res;
    }

}
