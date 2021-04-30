package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 输入：["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 说明："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 *
 * 输入：["a"]  输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：没有任何字符串被替代。
 *
 * 输入：["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。注意每个数字在数组中都有它自己的位置。
 *
 * @author Moonlight
 * @date 2021/4/30 13:01
 */
public class StringCompression {

    public static void main(String[] args) {
        char[] a = {'a', 'a', 'b', 'b', 'c', 'c', 'c'}, b = {'a'},
                c = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(a));
        System.out.println(compress(b));
        System.out.println(compress(c));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        // 如果只有一个就不用管，直接跳过
        // 如果有多个，就记好次数怼到后面
        int ans = 0, count = 0, pIndex = 0, index = 1;

        while (index < chars.length) {
            if (chars[index - 1] == chars[index]) {

            }
        }

        return ans;
    }

}
