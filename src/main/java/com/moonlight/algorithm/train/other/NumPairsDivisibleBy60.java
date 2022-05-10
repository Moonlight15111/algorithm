package com.moonlight.algorithm.train.other;

/**
 * https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 *
 * 输入：time = [30,20,150,100,40]  输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 *
 * 输入：time = [60,60,60]  输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 *
 * @author Moonlight
 */
public class NumPairsDivisibleBy60 {

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }
        // 取 60 的余，然后考虑两两配对的问题，1 + 59  2 + 58 ...
        int ans = 0, r = 0;
        int[] arr = new int[60];
        for (int t : time) {
            r = t % 60;
            ans += arr[r];
            arr[r == 0 ? 0 : 60 - r]++;
        }
        return ans;
    }

}
