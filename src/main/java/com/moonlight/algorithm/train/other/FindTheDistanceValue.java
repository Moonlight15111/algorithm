package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays/
 *
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 *
 * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2  输出：2
 *
 * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3  输出：2
 *
 * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6  输出：1
 *
 * @author Moonlight
 */
public class FindTheDistanceValue {

    public static void main(String[] args) {
        int[] a = {4, 5, 8}, b = {10, 9, 1, 8}, c = {1, 4, 2, 3}, d = {-4, -3, 6, 10, 20, 30},
              e = {2, 1, 100, 3}, f = {-5, -2, 10, -3, 7};
        System.out.println(findTheDistanceValue(a, b, 2));
        System.out.println(findTheDistanceValue(c, d, 3));
        System.out.println(findTheDistanceValue(e, f, 6));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        boolean f;
        for (int n : arr1) {
            f = true;
            for (int m : arr2) {
                if (Math.abs(n - m) <= d) {
                    f = false;
                    break;
                }
            }
            if (f) {
                ans++;
            }
        }
        return ans;
    }

}
