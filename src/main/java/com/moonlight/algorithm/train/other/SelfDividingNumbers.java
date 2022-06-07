package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/self-dividing-numbers/
 *
 * 自除数 是指可以被它包含的每一位数整除的数。
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 *
 * 1 <= left <= right <= 10^4
 *
 * 输入：left = 1, right = 22  输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * 输入：left = 47, right = 85  输出：[48,55,66,77]
 *
 * @author Moonlight
 */
public class SelfDividingNumbers {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
        System.out.println(selfDividingNumbers(47, 85));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        while (left <= right) {
            if (isSelfDividingNum(left)) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }

    private static boolean isSelfDividingNum(int left) {
        if (left < 10) {
            return true;
        }
        int t = left, r;
        while (t > 0) {
            r = t % 10;
            if (r == 0 || left % r != 0) {
                return false;
            }
            t /= 10;
        }
        return true;
    }

}
