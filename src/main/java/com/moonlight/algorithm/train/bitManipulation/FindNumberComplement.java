package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/number-complement/
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * @author Moonlight
 * @date 2020/12/19 10:30
 */
public class FindNumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        // num二进制有效位取反 =》 每个有效位与 1 进行异或即可 =》 需要一个二进制有效位与num相同且有效位全部为1的数
        int a = 1;
        while (a <= num) {
            a <<= 1;
        }
        a -= 1;
        return a ^ num;
    }

}
