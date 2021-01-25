package com.moonlight.algorithm.search;

/**
 * 给定一个无序数组arr，求该数组中第K小的数
 * @ClassName FindMinKth
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/25 22:16
 * @Version V1.0
 **/
public class FindMinKth {

    public static void main(String[] args) {
        int[] arr = {0, 4, 1, 1, 9, 3, 11, 9, 10, 7, 4};
        System.out.println(findMinKth(arr, 2));
    }

    public static int findMinKth(int[] arr, int k) {
        return process(arr, 0, arr.length - 1, k - 1);
    }

    private static int process(int[] arr, int left, int right, int index) {
        if (left == right) {
            return arr[left];
        }
        int pivot = arr[left + (int)(Math.random() * (right - left + 1))];
        int[] range = partition(arr, left, right, pivot);
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return process(arr, left, range[0] - 1, index);
        } else {
            return process(arr, range[1] + 1, right, index);
        }
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
