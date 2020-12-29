package com.moonlight.algorithm.train.heap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author Moonlight
 * @date 2020/12/29 11:12
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
        int[] arrrr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arrrr, 4));
    }

    public static int findKthLargest(int[] arr, int k) {
        buildHeap(arr);
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, heapSize);
        }
        return arr[k - 1];
    }

    private static void heapify(int[] arr, int heapSize) {
        int index = 0, left = (2 * index) + 1, smaller;
        while (left < heapSize) {
            smaller = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1 : left;
            smaller = arr[index] < arr[smaller] ? index : smaller;
            if (smaller == index) {
                break;
            }
            swap(arr, smaller, index);
            index = smaller;
            left = (2 * index) + 1;
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = 0, len = arr.length, index, parentIndex; i < len; i++) {
            index = i;
            parentIndex = (index - 1) / 2;
            while (arr[index] < arr[parentIndex]) {
                swap(arr, index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }
    }

    private static void swap(int[] arr, int index, int parentIndex) {
        int tmp = arr[index];
        arr[index] = arr[parentIndex];
        arr[parentIndex] = tmp;
    }

}
