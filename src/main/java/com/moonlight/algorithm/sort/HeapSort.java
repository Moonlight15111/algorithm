package com.moonlight.algorithm.sort;


import com.moonlight.algorithm.Const;

/**
 * @ClassName HeapSort
 * @Description: 将数组组成一个大根堆的形式，然后将堆的根节点与最后一个节点交换，并将堆的数量 - 1，使其不可达，循环此过程
 * @Author Moonlight
 * @Date 2020/5/4 22:20
 * @Version V1.0
 **/
public class HeapSort implements Sort {

    public static void main(String[] args){
        Sort sort = new HeapSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }

    @Override
    public void sort(int[] arr) {
        buildHeap(arr);
        int length = arr.length;
        // 最大值调换到末尾，减少堆的大小，使其不可达，周而复始，即可排序
        while (length > 0) {
            swap(arr, 0, length - 1);
            length--;
            heapify(arr, 0, length);
        }
    }

    private void buildHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i, parentIndex = (index - 1) / 2;
            while (arr[index] > arr[parentIndex]) {
                swap(arr, index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }
    }

    private void heapify(int[] arr, int index, int length) {
        int left = 2 * index + 1;
        while (left < length) {
            int largest = left + 1 < length && arr[left] < arr[left + 1] ? left + 1 : left;

            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }
}
