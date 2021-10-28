package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reordered-power-of-2/
 *
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 * 输入：1  输出：true
 *
 * 输入：10  输出：false
 *
 * 输入：16  输出：true
 *
 * 输入：24  输出：false
 *
 * 输入：46  输出：true
 *
 * @author Moonlight
 */
public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));
    }

    public static boolean reorderedPowerOf2(int n) {
        if (isPowerOfTwo(n)) {
            return true;
        }
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        boolean[] vis = new boolean[chars.length];
        List<String> list = new ArrayList<>();

        backtrack(new StringBuilder(), vis, chars, list);

        return list.size() > 0;
    }

    private static void backtrack(StringBuilder path, boolean[] vis, char[] chars, List<String> list) {
        if (path.length() == chars.length) {
            if (path.toString().startsWith("0")) {
                return;
            }
            long parse = Long.parseLong(path.toString());
            if (isPowerOfTwo(parse)) {
                list.add(path.toString());
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!vis[i]) {
                path.append(chars[i]);
                vis[i] = true;
                backtrack(path, vis, chars, list);
                if (list.size() > 0) {
                    return;
                }
                vis[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private static boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}