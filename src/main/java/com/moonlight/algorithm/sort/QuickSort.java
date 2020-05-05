package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName QuickSort
 * @Description: 选定一个轴，按轴将数据分为小于等于 和 大于两个区。左指针从左往右遍历，右指针从右往左遍历
 *               左指针遇见大于pivot的停下，右指针遇见小于等于pivot的数停下，两者进行交换，二者相遇时循环结束。最后将pivot与左指针进行交换
 *               返回左右指针，作为下次分区的依据
 * @Author Moonlight
 * @Date 2020/5/3 22:43
 * @Version V1.0
 **/
public class QuickSort implements Sort {

    public static void main(String[] args){
        Sort sort = new QuickSort();
        sort.sort(Const.arr);
        Const.print(Const.arr);
    }

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end){
        if(start >= end) return;

//        int partition_pivot = partition(arr, start, end);
//        sort(arr, start, partition_pivot - 1);
//        sort(arr, partition_pivot + 1, end);

//        int[] res = partition2(arr, start, end);
        int[] res = partition2(arr, start + ((int) (Math.random() * (end - start + 1))), end);

        sort(arr, start, res[0] - 1);
        sort(arr, res[1] + 1, end);
    }

    public int partition(int[] arr, int start, int end){
        int pivot = arr[end], leftPtr = start, rightPtr = end - 1;
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
        swap(arr, leftPtr, end);
        return leftPtr;
    }

    public int[] partition2(int[] arr, int start, int end){
        int pivot = arr[end], leftPtr = start, rightPtr = end - 1;
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
        swap(arr, leftPtr, end);
        return new int[]{leftPtr, rightPtr};
    }

}
