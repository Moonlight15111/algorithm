package com.moonlight.algorithm.bitop;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * &  简单理解，按位相乘    |  简单理解，不进位加   ^  同0异1
 * ~  取反运算，0 则变为 1，1 则变为 0
 * << 左移运算，向左进行移位操作，高位丢弃，低位补 0
 * >> 右移运算，向右进行移位操作，对无符号数，高位补 0，对于有符号数，高位补符号位   >>> 无符号右移，不管符号位，直接补0
 * @author Moonlight
 * @date 2020/12/19 10:49
 */
public class BitBaseOp {

    public static void swap(int a, int b) {
        // 两数交换
        a ^= b;
        b ^= a;
        a ^= b;
    }

    public static void oddNumber(int num) {
        // 求奇偶
        if (0 == (num & 1)) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }
    }

    public static int reversal(int num) {
        // 正数变成负数，负数变成正数   本质其实是 补码 = 反码 + 1    反码 = 补码 - 1
        return ~num + 1;
    }

    public static int abs(int num) {
        // 求绝对值
        // 对于任何数与 0 异或都会保持不变，与 -1 即 0xffffffff 进行异或就相当于对此数进行取反,
        int i = num >> 31;
        return i == 0 ? num : (~num + 1);
    }

    public static int highLowSwap(int num) {
        // 高低位交换
        return (num >> 16) | (num << 16);
    }

    public static int bitReverseOrder(int num) {
        // 先分别取原数的奇数位和偶数位，将空余位用 0 填充 再将奇数位右移一位，偶数位左移一位，此时将两个数据相或即可以达到奇偶位上数据交换的效果
        num = ((num & 0xAAAAAAAA) >> 1) | ((num & 0x55555555) << 1);
//        num = ((num & 0xCCCCCCCC) >> 2) | ((num & 0x33333333) << 2);
//        num = ((num & 0xF0F0) >> 4) | ((num & 0x0F0F) << 4);
//        num = ((num & 0xFF00) >> 8) | ((num & 0x00FF) << 8);
//        num = ((num & 0xFF00) >> 16) | ((num & 0x00FF) << 16);
        return num;
    }

    public static void main(String[] args) {
        System.out.println((12 & (12 - 1)));
        System.out.println(bit1Count(9));
    }

    public static int highestOneBit(int i) {
        // 获取最高位的1
        i |= (i >>> 1);
        i |= (i >>> 2);
        i |= (i >>> 4);
        i |= (i >>> 8);
        i |= (i >>> 16);
        return i ^ (i >>> 1);
    }

    public static int change2ZeroK(int n, int k) {
        // 将数字 n 二进制的第 K 位设置为0
        if ((n & (1 << k)) != 0) {
            n -= (1 << k);
        }
        return n;
    }

    public static int bit1Count(int num) {
        int count = 0;
        while(num != 0){
            count++;
            // 取最右边的1
            int farRightOne = num & (-num); // num = num & (~num + 1)
            // 消掉最右边的1
            num ^= farRightOne;
            // num = num & (num - 1);
        }
        return count;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
