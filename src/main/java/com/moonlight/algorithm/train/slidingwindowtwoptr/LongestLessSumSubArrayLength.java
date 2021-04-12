package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 给定一个数组，求和小于等于的K的最长子数组的长度
 *
 * @ClassName LongestLessSumSubArrayLengthIIII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/12 23:35
 * @Version V1.0
 **/
public class LongestLessSumSubArrayLength {

    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 1.先统计出以 i 位置为起点，和最小的子数组的长度及最长的位置在哪
        // 2.从头遍历数组，取出每个位置和最小位置，往右边扩充
        int[] minSum = new int[arr.length];
        int[] minSumEnd = new int[arr.length];
        minSum[arr.length - 1] = arr[arr.length - 1];
        minSumEnd[arr.length - 1] = arr.length - 1;

        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i + 1] <= 0) {
                minSum[i] = arr[i] + minSum[i + 1];
                minSumEnd[i] = minSumEnd[i + 1];
            } else {
                minSum[i] = arr[i];
                minSumEnd[i] = i;
            }
        }

        int end = 0, sum = 0, res = 0;
        // i是窗口的最左的位置，end扩出来的最右有效块儿的最后一个位置的，再下一个位置
        // end也是下一块儿的开始位置
        // 窗口：[i~end)
        for (int i = 0; i < arr.length; i++) {
            // while循环结束之后：
            // 1) 如果以i开头的情况下，累加和<=k的最长子数组是arr[i..end-1]，看看这个子数组长度能不能更新res；
            // 2) 如果以i开头的情况下，累加和<=k的最长子数组比arr[i..end-1]短，更新还是不更新res都不会影响最终结果；
            while (end < arr.length && sum + minSum[end] <= k) {
                sum += minSum[end];
                end = minSumEnd[end] + 1;
            }
            res = Math.max(res, end - i);
            if (end > i) { // 窗口内还有数 [i~end) [4,4)
                sum -= arr[i];
            } else { // 窗口内已经没有数了，说明从i开头的所有子数组累加和都不可能<=k
                end = i + 1;
            }
        }
        return res;

    }

}
