package com.moonlight.algorithm.train.other;

/**
 * 定义一种数：可以表示成若干个(数量大于1)连续正数和的数
 * 如： 5 = 2 + 3，12 = 3 + 4 + 5
 * 1不是这样的数，因为要求数量大于1个、连续正数和
 * 2也不是
 * 给定一个数N，返回是不是可以表示成若干连续正数和的数
 *
 * @ClassName MSumToN
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/3 19:21
 * @Version V1.0
 **/
public class MSumToN {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ": " + isMSum(i) + "   ===  " + isMSum123(i));
        }
    }

    public static boolean isMSum123(int n) {
        if (n < 3) {
            return false;
        }
        return (n & (n - 1)) != 0;
    }

    public static boolean isMSum(int n) {
        for (int i = 1; i <= n ; i++) {
            int sum = i;
            for (int j = i + 1; j <= n; j++) {
                if (sum + j > n) {
                    break;
                }
                if (sum + j == n) {
                    return true;
                }
                sum += j;
            }
        }
        return false;
    }


}
