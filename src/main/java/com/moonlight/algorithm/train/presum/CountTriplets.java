package com.moonlight.algorithm.train.presum;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * <p>
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <p>
 * 输入：arr = [2,3,1,6,7]    输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * <p>
 * 输入：arr = [1,1,1,1,1]   输出：10
 * <p>
 * 输入：arr = [2,3]  输出：0
 * <p>
 * 输入：arr = [1,3,5,7,9]   输出：3
 * <p>
 * 输入：arr = [7,11,12,9,5,2,7,17,22]   输出：8
 *
 * @author Moonlight
 * @date 2021/5/18 13:10
 */
public class CountTriplets {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 6, 7}, b = {1, 1, 1, 1, 1}, c = {2, 3}, d = {1, 3, 5, 7, 9}, e = {7, 11, 12, 9, 5, 2, 7, 17, 22};
        System.out.println(countTriplets(a));
        System.out.println(countTriplets(b));
        System.out.println(countTriplets(c));
        System.out.println(countTriplets(d));
        System.out.println(countTriplets(e));
    }

    public static int countTriplets(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int n = arr.length;
        int[] preXor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preXor[i + 1] = arr[i] ^ preXor[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (preXor[i] == preXor[j + 1]) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }

}
