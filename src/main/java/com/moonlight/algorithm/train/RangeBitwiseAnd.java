package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/17 16:29
 */
public class RangeBitwiseAnd {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));

        System.out.println(rangeBitwiseAnd22222(5, 7));
        System.out.println(rangeBitwiseAnd22222(0, 1));
    }

    public static int rangeBitwiseAnd22222(int m, int n) {
        // Integer.MAX_VALUE == 2147483647 && m <= n && n <= 2147483647
        if (m == Integer.MAX_VALUE || m == n) {
            return m;
        }

        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
            // 2147483647 + 1 == -2147483648 => 差不多是个死循环了
            if(res == 0 ||  i == Integer.MAX_VALUE){
                break;
            }
        }
        return res;
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }

}
