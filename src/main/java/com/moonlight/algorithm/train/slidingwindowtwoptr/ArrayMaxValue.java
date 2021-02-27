package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设一个固定大小为W的窗口，依次划过arr，
 * 返回每一次滑出状况的最大值
 * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
 * 返回：[5,5,5,4,6,7]
 * @ClassName ArrayMaxValue
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/11 21:10
 * @Version V1.0
 **/
public class ArrayMaxValue {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(arrayMaxVal(arr, 3)));
    }

    public static int[] arrayMaxVal(int[] arr, int w) {
        if (arr == null || arr.length == 0 || arr.length < w) {
            return new int[0];
        }
        // 滑动窗口  双端队列记录当前窗口最大值
        // 只有当队列为空 或者 队列尾巴的数大于当前数时才往尾巴上加数据
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.addLast(i);
            // 移除过期的数据
            if (i - w == list.peekFirst()) {
                list.pollFirst();
            }
            // 是否形成窗口
            if (i >= w - 1) {
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }

}
