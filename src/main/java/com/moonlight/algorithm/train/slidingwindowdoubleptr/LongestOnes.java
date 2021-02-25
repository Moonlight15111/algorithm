package com.moonlight.algorithm.train.slidingwindowdoubleptr;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * @author Moonlight
 * @date 2021/2/19 9:51
 */
public class LongestOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(arr, 2));

        int[] arrrrr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(arrrrr, 3));
    }

    public static int longestOnes(int[] A, int K) {
        if (A == null) {
            return 0;
        }
        if (A.length == 0 || A.length <= K) {
            return A.length;
        }
        int leftPtr = 0, rightPtr = 0, length = A.length, changeTimes = 0, result = 0;

        while (leftPtr < length && rightPtr < length) {
            if (A[rightPtr] == 0) {
                changeTimes++;
            }
            rightPtr++;

            while (changeTimes > K) {
                if (A[leftPtr] == 0) {
                    changeTimes--;
                }
                leftPtr++;
            }
            result = Math.max(result, rightPtr - leftPtr);
        }

        return result;
    }

}
