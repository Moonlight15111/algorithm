package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，
 * 如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 * 输入：arr = [17,18,5,4,6,1]  输出：[18,6,6,6,1,-1]
 *
 * 输入：arr = [400]  输出：[-1]
 *
 * @ClassName ReplaceElements
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/16 11:10
 * @Version V1.0
 **/
public class ReplaceElements {

    public static void main(String[] args) {
        int[] a = {17, 18, 5, 4, 6, 1}, b = {400};
        System.out.println(Arrays.toString(replaceElements(a)));
        System.out.println(Arrays.toString(replaceElements(b)));
    }

    public static int[] replaceElements(int[] arr) {
        int len = arr.length, max = arr[len - 1];
        int[] ans = new int[len];
        ans[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            ans[i] = max;
            max = Math.max(arr[i], max);
        }
        return ans;
    }

}
