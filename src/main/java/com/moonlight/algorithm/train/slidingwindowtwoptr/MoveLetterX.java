package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 给定一个数组，编写一个函数将所有"×"移动到教组的末尾，同时保持非"X"元素的相对顺序
 * 输入:["L","X","E","J","X","I","A", "N"]
 * 输出:[“L","E","J"."I","A","N","X","X"]
 * <p>
 * 输入:["X","X","E","J","X","I","A", "X"]
 * 输出:[“E","J", "I","A","X","X","X","X"]
 * <p>
 * 说明: 必须在原数组上操作,不能铂贝额外的数组。尽量减少操作次数。
 *
 * @ClassName MoveLetterX
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/27 20:50
 * @Version V1.0
 **/
public class MoveLetterX {

    public static void main(String[] args) {
        String[] a = {"L", "X", "E", "J", "X", "I", "A", "N" },
                b = {"X", "X", "E", "J", "X", "I", "A", "X" };
//        move(a);
//        move(b);
        move12313(a);
        move12313(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void move12313(String[] arr) {
        int prev = 0, cur = 0;
        while (cur < arr.length) {
            if (!"X".equals(arr[cur])) {
                arr[prev++] = arr[cur];
            }
            cur++;
        }
        for (int i = prev; i < arr.length; i++) {
            arr[i] = "X";
        }
    }

    public static void move(String[] arr) {
        int left = 0, right = 0;
        while (left <= right && right < arr.length) {
            if ("X".equals(arr[left])) {
                if (!"X".equals(arr[right])) {
                    arr[left] = arr[right];
                    arr[right] = "X";
                    left++;
                }
            } else {
                left++;
            }
            right++;
        }
    }

}
