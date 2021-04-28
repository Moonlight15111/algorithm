package com.moonlight.algorithm.train.backtrack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 输入: "112358"  输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 输入: "199100199"  输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * @author Moonlight
 * @date 2021/4/28 13:19
 */
public class IsAdditiveNumber {

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("199100199"));
    }

    public static boolean isAdditiveNumber(String num) {
        return num.length() >= 3 && process(num.toCharArray(), 0, 0, 0, 0);
    }

    // index 当前来到的位置     prev 前一个数   sum 前两个数的和  count 有几个数了
    private static boolean process(char[] chars, int index, long prev, long sum, int count) {
        if (index >= chars.length) {
            return count > 2;
        }
        for (int i = index; i < chars.length; i++) {
            long cur = getNum(chars, index, i);
            // 如果cur < 0 说明没有组装出有效的数字
            if (cur < 0) {
                continue;
            }
            // 最少已经有两个数了, 则判断第三个数是不是前两个数的和
            // 如果当前数小于sum那么说明还可以继续往下面走，如果已经大于了，那就没有下去的必要了
            if (count >= 2) {
                if (cur < sum) {
                    continue;
                } else if (cur > sum) {
                    break;
                }
            }
            if (process(chars, i + 1, cur, prev + cur, count + 1)) {
                return true;
            }
        }
        return false;
    }

    private static long getNum(char[] chars, int start, int end) {
        if (start > end || (start < end && chars[start] == '0')) {
            return -1;
        }
        long ans = 0;
        while (start <= end) {
            ans = ans * 10 + chars[start++] - '0';
        }
        return ans;
    }

}
