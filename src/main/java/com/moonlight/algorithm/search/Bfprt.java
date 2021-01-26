package com.moonlight.algorithm.search;

import java.util.Arrays;

/**
 * @ClassName Bfprt
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/26 21:40
 * @Version V1.0
 **/
public class Bfprt {

    public static void main(String[] args) {
        int[] arr = {0, 4, 1, 1, 9, 3, 11, 9, 10, 7, 4};
        System.out.println(findMinKth(arr, 2));
    }

    public static int findMinKth(int[] arr, int k) {
        return bfprt(arr, 0, arr.length - 1, k - 1);
    }

    // 五个数一组，剩下不足五个的做一组
    // 每个小组自己内部排序
    // 每个小组自己的中位数拎出来，不足五个的那组取上中点，组成一个midArr
    // 在midArr上面继续上述行为，直到取到唯一一个中位数
    // 以这个中位数为轴进行partitition，小于在左，等于在中，大于在右
    // 判断index在哪个区间范围上，在该区间范围重复上述所有操作
    private static int bfprt(int[] arr, int left, int right, int index) {
        if (left == right) {
            return arr[left];
        }
        int pivot = medianOfMedians(arr, left, right);
        int[] range = partition(arr, left, right, pivot);
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return bfprt(arr, left, range[0] - 1, index);
        } else {
            return bfprt(arr, range[1] + 1, right, index);
        }
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offSet = size % 5 == 0 ? 0 : 1;
        int[] midArr = new int[size / 5 + offSet];
        for (int mid = 0; mid < midArr.length;mid++) {
            int midFirst = left + mid * 5;
            midArr[mid] = getMedian(arr, midFirst, Math.min(right, midFirst + 4));
        }
        return bfprt(midArr, 0, midArr.length - 1, midArr.length / 2);
    }

    private static int getMedian(int[] arr, int left, int right) {
        Arrays.sort(arr, left, right);
        return arr[(left + right) / 2];
    }

    private static int[] partition(int[] arr, int left, int right, int pivot) {
        int leftPtr = left, rightPtr = right - 1;
        while (leftPtr <= rightPtr) {
            while (leftPtr <= rightPtr && arr[leftPtr] <= pivot) {
                leftPtr++;
            }
            while (leftPtr <= rightPtr && arr[rightPtr] > pivot) {
                rightPtr--;
            }
            if (leftPtr < rightPtr) {
                swap(arr, leftPtr, rightPtr);
            }
        }
        swap(arr, leftPtr, right);
        return new int[]{leftPtr, rightPtr};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
