package com.moonlight.algorithm.train.heap;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * @author Moonlight
 * @date 2020/12/29 10:39
 */
public class GetLeastKNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 4)));
        int[] arr22 = {3, 1, 2};
        System.out.println(Arrays.toString(getLeastNumbers(arr22, 2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        buildHeap(arr);

        int heapSize = arr.length;

        while (heapSize > 0) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, heapSize);
        }

        int[] res = new int[k];

        System.arraycopy(arr, 0, res, 0, k);

        return res;
    }

    private static void heapify(int[] arr, int heapSize) {
        int index = 0;
        int left = (2 * index) + 1, largest;
        while (left < heapSize) {
            largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = (2 * index) + 1;
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = 0, len = arr.length, index, parentIndex; i < len; i++) {
            index = i;
            parentIndex = (index - 1) / 2;
            while (arr[index] > arr[parentIndex]) {
                swap(arr, index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }
    }

    private static void swap(int[] arr, int index, int parentIndex) {
        int i = arr[index];
        arr[index] = arr[parentIndex];
        arr[parentIndex] = i;
    }

}
