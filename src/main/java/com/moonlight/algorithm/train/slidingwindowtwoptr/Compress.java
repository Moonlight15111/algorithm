package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/string-compression/
 *
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 进阶：你能否仅使用O(1) 空间解决问题？
 *
 * 输入：["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 说明："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 *
 * 输入：["a"]  输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 *
 * 输入：["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 *       注意每个数字在数组中都有它自己的位置。
 *
 * @author Moonlight
 * @date 2021/7/15 15:55
 */
public class Compress {

    public static void main(String[] args) {
        char[] a = {'a', 'a', 'b', 'b', 'c', 'c', 'c'},
                b = {'a'},
                c = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(a));
        System.out.println(compress(b));
        System.out.println(compress(c));
    }

    public static int compress(char[] chars) {
        // 三个指针: 读、写、起点
        // 读: 往前读   写: 更新原数组，将长度记录刷写到原数组中去   起点: 标记字符起始位置
        // 使用s标记字符的起始位置，并使用读指针往前读取字符，读到下一个字符与当前字符不同或者数组末尾的时候，说明相同字符的连续区间已经读取完毕
        // 那么从 s 到 r 这一段就是一个字符的连续区间，其长度为 r - s + 1 ，然后通过写指针写到原数组中去
        int s = 0, w = 0, len = chars.length;
        for (int r = 0; r < len; r++) {
            if (r + 1 == len || chars[r] != chars[r + 1]) {
                chars[w++] = chars[s];
                if (r > s) {
                    for (char c : ((r - s + 1) + "").toCharArray()) {
                        chars[w++] = c;
                    }
                }
                s = r + 1;
            }
        }
        return w;
    }

}
