package com.moonlight.algorithm.train.slidingwindow;

import java.util.LinkedList;

/**
 * 给定一个整型数组arr，和一个整数num
 * 某个arr中的子数组sub，如果想达标，必须满足：
 * sub中最大值 – sub中最小值 <= num，
 * 返回arr中达标子数组的数量
 * @ClassName AllLessNumSubArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/11 21:53
 * @Version V1.0
 **/
public class AllLessNumSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 7, 4, 2, 3, 8, 9};
        System.out.println(lessNumSubArray(arr, 4));
    }

    public static int lessNumSubArray(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 滑动窗口  双端队列记录当前窗口最大值/最小值
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int len = arr.length, left = 0, right = 0, res = 0;
        while (left < len) {

            while (right < len) {

                while (!min.isEmpty() && arr[min.peekLast()] >= arr[right]) {
                    min.pollLast();
                }
                min.addLast(right);

                while (!max.isEmpty() && arr[max.peekLast()] <= arr[right]) {
                    max.pollLast();
                }
                max.addLast(right);

                if (arr[max.getFirst()] - arr[min.getFirst()] > num) {
                    break;
                }
                right++;
            }

            res += right - left;

            if (min.peekFirst() == left) {
                min.pollFirst();
            }
            if (max.peekFirst() == left) {
                max.pollFirst();
            }

            left++;
        }
        return res;
    }

}
