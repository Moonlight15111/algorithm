package com.moonlight.algorithm.train.other;

/**
 * 商店只提供两种类型的袋子：
 *   1.只能装下6个苹果
 *   2.只能装下8个苹果
 * 给定一个正整数N，表示要买的苹果数
 * 可以自由地使用两种类型的袋子，但是要求使用的袋子数量最少
 * 且每个袋子都必须装满
 * 返回最少的袋子数量，如果N无法让使用地每个袋子都装满，则返回-1
 *
 * @ClassName MinBag
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/3 13:53
 * @Version V1.0
 **/
public class MinBag {

    public static void main(String[] args) {
        System.out.println(minBag(13));
        System.out.println(minBag(46));

        System.out.println(minBag123(13));
        System.out.println(minBag123(46));
    }

    public static int minBag123(int n) {
        if ((n & 1) != 0 || n < 6 || n == 7) {
            return -1;
        }
        if (n == 6 || n == 8) {
            return 1;
        }
        if (n < 18) {
            return n == 12 || n == 14 || n == 16 ? 2 : -1;
        }
        return (n - 18) / 8 + 3;
    }

    public static int minBag(int n) {
        if ((n & 1) != 0 || n < 6 || n == 7) {
            return -1;
        }
        if (n == 6 || n == 8) {
            return 1;
        }
        int y = -1;
        int x = n / 8, rest = n - 8 * x;
        while (x >= 0 && rest < 24) {
            if (rest % 6 == 0) {
                y = rest / 6;
                break;
            }
            x -= 1;
            rest = n - 8 * x;
        }
        return y == -1 ? -1 : x + y;
    }

}
