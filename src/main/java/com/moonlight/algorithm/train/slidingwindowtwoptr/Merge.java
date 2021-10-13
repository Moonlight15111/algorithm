package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * A.length == n + m
 *
 * @ClassName Merge
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/13 21:31
 * @Version V1.0
 **/
public class Merge {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0}, b = {2, 5, 6};
        merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] A, int m, int[] B, int n) {
//        System.arraycopy(B, 0, A, m, n);
//        Arrays.sort(A);
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[i + j + 1] = B[j--];
            } else {
                A[i + j + 1] = A[i--];
            }
        }
        while (j >= 0) {
            A[j] = B[j--];
        }
    }

}
