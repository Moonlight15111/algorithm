package com.moonlight.algorithm.train.search;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 输入：n = 2
 * 输出：false
 *
 * @ClassName HappyNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/3 0:00
 * @Version V1.0
 **/
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy123(19));

        System.out.println(isHappy(2));
        System.out.println(isHappy123(2));
    }

    public static boolean isHappy123(int n) {
        int slow = n;
        int fast = getNewNum(n);
        while (fast != 1 && slow != fast) {
            slow = getNewNum(slow);
            fast = getNewNum(getNewNum(fast));
        }
        return fast == 1;
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        n = getNewNum(n);
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = getNewNum(n);
        }
        return true;
    }

    public static int getNewNum(int n) {
        int res = 0;
        while (n != 0) {
            int a = n % 10;
            res += (a * a);
            n /= 10;
        }
        return res;
    }

}
