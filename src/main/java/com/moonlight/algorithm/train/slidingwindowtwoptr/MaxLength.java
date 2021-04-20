package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 *
 * 给定一个有序数组arr，代表坐落在X轴上的点
 * 给定一个正数K，代表绳子的长度
 * 返回绳子最多压中几个点？
 * 即使绳子边缘处盖住点也算盖住
 *
 * @ClassName MaxLength
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/20 20:11
 * @Version V1.0
 **/
public class MaxLength {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 9, 10, 11, 12};
        System.out.println(maxLength(a, 4));
    }

    public static int maxLength(int[] arr, int k) {
        int left = 0, right = 0, n = arr.length, ans = 0;
        while (left < n) {
            while (right < n && arr[right] - arr[left] <= k) {
                right++;
            }
            ans = Math.max(ans, right - left);
            left++;
        }
        return ans;
    }

}
