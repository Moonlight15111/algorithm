package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/3sum-with-multiplicity/
 *
 * 给定一个整数数组 A，以及一个整数 target 作为目标值
 * 返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 *
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8   输出：20
 * 解释：按值枚举（A[i]，A[j]，A[k]）:
 *                (1, 2, 5) 出现 8 次；
 *                (1, 3, 4) 出现 8 次；
 *                (2, 2, 4) 出现 2 次；
 *                (2, 3, 3) 出现 2 次。
 *
 * 输入：A = [1,1,2,2,2,2], target = 5   输出：12
 * 解释：A[i] = 1，A[j] = A[k] = 2 出现 12 次：
 *       我们从 [1,1] 中选择一个 1，有 2 种情况，
 *       从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 *
 *
 * @author Moonlight
 * @date 2021/3/4 11:59
 */
public class ThreeSumMulti {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] b = {1, 1, 2, 2, 2, 2};
        // 20
        System.out.println(threeSumMulti(a, 8));
        // 12
        System.out.println(threeSumMulti(b, 5));

        System.out.println(threeSumMul(a, 8));
        System.out.println(threeSumMul(b, 5));
    }

    public static int threeSumMul(int[] arr, int target) {
        int res = 0, sum, leftPtr, rightPtr, len = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < len; i++) {
            leftPtr = i + 1;
            rightPtr = len - 1;

            while (leftPtr < rightPtr && leftPtr < len) {
                sum = arr[i] + arr[leftPtr] + arr[rightPtr];
                if (sum > target) {
                    rightPtr--;
                } else if (sum < target) {
                    leftPtr++;
                } else {
                    // 等于target的情况下需要考虑重复值

                    // leftPtr 和 rightPtr不等的情况下：
                    // 比如：1, 1, 2, 2, 3, 3, 4, 4, 5, 5   target = 8
                    // 那么数组中有大量的重复值可以组成target
                    // 对于这种情况,只要能够组成target，我们就应该要算它，如：1 + 2 + 5 = 8 => 2 * 2 * 2 = 8种组合

                    // leftPtr 和 rightPtr相等的情况下：
                    // m = m * (m - 1) / 2, m = rightPtr - leftPtr
                    if (arr[leftPtr] != arr[rightPtr]) {
                        int left = 1, right = 1;
                        while (leftPtr + 1 < rightPtr && arr[leftPtr] == arr[leftPtr + 1]) {
                            left++;
                            leftPtr++;
                        }
                        while (rightPtr - 1 > leftPtr && arr[rightPtr] == arr[rightPtr - 1]) {
                            right++;
                            rightPtr--;
                        }
                        res += left * right;
                        res %= 1_000_000_007;
                        leftPtr++;
                        rightPtr--;
                    } else {
                        res += (rightPtr - leftPtr + 1) * (rightPtr - leftPtr) / 2;
                        res %= 1_000_000_007;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int threeSumMulti(int[] arr, int target) {
        // 定住两个，找第三个
        // 超时
        int res = 0, rightPtr = 0, length = arr.length, sum;

        Arrays.sort(arr);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                rightPtr = j + 1;
                while (rightPtr < length) {
                    sum = arr[i] + arr[j] + arr[rightPtr];
                    if (sum == target) {
                        res++;
                    }
                    rightPtr++;
                }
            }
        }
        return res % 1000000007;
    }

}
