package com.moonlight.algorithm.search;

/**
 * @ClassName BinarySearch
 * @Description: 二分查找
 * @Author Moonlight
 * @Date 2020/5/2 16:52
 * @Version V1.0
 **/
public class BinarySearch {

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(arr, 6));
        System.out.println(exist(arr, 6));
    }

    public static int search(int[] arr, int num){
        int pos = -1;

        if (arr == null) {
            return pos;
        }

        for (int start = 0, end = arr.length - 1; start <= end;) {
            int middle = (start + end) / 2;
            if (arr[middle] == num) {
                pos = middle;
                break;
            } else if (arr[middle] < num) {
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        return pos;
    }

    public static boolean exist(int[] arr, int num){
        if (arr == null) {
            return false;
        }

        int left = 0, right = arr.length, mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[mid] == num;
    }

}
