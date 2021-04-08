package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @author Moonlight
 * @date 2021/4/8 13:24
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] a = {'h', 'e', 'l', 'l', 'o'}, b = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(a);
        reverseString(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

}
