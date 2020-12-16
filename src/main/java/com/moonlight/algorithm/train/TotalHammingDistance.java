package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/total-hamming-distance/submissions/
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * @author Moonlight
 * @date 2020/12/16 11:15
 */
public class TotalHammingDistance {

    public static void main(String[] args) {
        int[] arr = {4, 14, 2};
        System.out.println(totalHammingDistance1(arr));
        System.out.println(totalHammingDistance2(arr));
    }

    public static int totalHammingDistance2(int[] nums) {
        // 0 和 0，1 和 1 的汉明距离为0，只有0 和 1 的汉明距离为 1，假设现在有 m 个 0 n 个 1 那么汉明距离应该为 m * n
        // 所以统计数组中数据，每个位上0 和 1 的个数然后相乘
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        int oneCount = 0, zeroCount = 0;
        for (int i = 0; i < 32; i++) {
            oneCount = 0;
            zeroCount = 0;
            for (int n : nums) {
                if ((n & 1 << i) == (1 << i)) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            res += (oneCount * zeroCount);
        }
        return res;
    }

    public static int totalHammingDistance1(int[] nums) {
        // 暴力破解。双层循环，根据异或 同 0 异 1 的特性，统计有多少个 1
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;

        for (int i = 0, length = nums.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                res += getHammingDistance(nums[i], nums[j]);
            }
        }
        return res;
    }

    private static int getHammingDistance(int i, int j) {
        int n = i ^ j;
        System.out.println(Integer.toBinaryString(n));
        int diff = 0;
        int farRightNumOne;
        while (n != 0) {
            farRightNumOne = n & (-n);
            diff++;
            n ^= farRightNumOne;
        }
        return diff;
    }
}
