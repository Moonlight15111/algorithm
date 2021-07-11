package com.moonlight.algorithm.train.contest.biweeklycontest56;

/**
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 *
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 *
 * 输入：n = 5   输出：2
 * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 *
 * 输入：n = 10  输出：4
 * 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
 *
 * @ClassName CountTriples
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/7/10 22:37
 * @Version V1.0
 **/
public class CountTriples {

    public static void main(String[] args) {
        System.out.println(countTriples(5));
        System.out.println(countTriples(10));
        System.out.println(countTriples(15));
    }

    public static int countTriples(int n) {
        if (n < 5) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 1; k <= n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int a = i * i, b = j * j, c = k * k;
                    if ((a + b == c) || (a + c == b) || (c + b == a)) {
                        ans++;
                    }
                }
            }
        }
        return ans / 3;
    }

}