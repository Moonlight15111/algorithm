package com.moonlight.algorithm.train.greedy;

/**
 * 原题：https://leetcode-cn.com/problems/can-place-flowers/
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回
 * True，不能则返回False。
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * @ClassName CanPlaceFlowers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/1 18:15
 * @Version V1.0
 **/
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(arr, 1));
        System.out.println(canPlaceFlowers(arr, 2));
        int[] arr2 = {0, 1, 0, 0, 1, 0, 0, 0};
        System.out.println(canPlaceFlowers(arr2, 1));
        System.out.println(canPlaceFlowers(arr2, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < n) {
            return false;
        }
        // 如果当前位置是0，且前一个位置也为0或当前位置是1就往前走两步
        // 如果当前位置是0，且下一个位置是1，就往前走三步
        for (int i = 0, length = flowerbed.length; i < length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }

}
