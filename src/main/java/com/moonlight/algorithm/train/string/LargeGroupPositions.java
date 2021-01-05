package com.moonlight.algorithm.train.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/positions-of-large-groups/
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分
 * 组用区间表示为 [3,6] 。
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 *
 * 输入：s = "aba"
 * 输出：[]
 *
 * @author Moonlight
 * @date 2021/1/5 12:47
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        String s1 = "aaa";
        for (List<Integer> list : largeGroupPositions(s1)) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.print("]");
        }
        System.out.println();
        for (List<Integer> list : largeGroupPositions222(s1)) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.print("]");
        }
    }

    public static List<List<Integer>> largeGroupPositions222(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int len = s.length();
        List<Integer> tmp;
        for (int left = 0, right = 0; right <= len; right++) {
            if (left == right || right == len || s.charAt(left) != s.charAt(right)) {
                if (right - left >= 3) {
                    tmp = new ArrayList<>();
                    tmp.add(left);
                    tmp.add(right - 1);
                    res.add(tmp);
                }
                left = right;
            }
        }
        return res;
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        List<Integer> tmp;
        for (int i = 0, count, j, length = s.length(); i < length;) {
            count = 0;
            j = i;
            while (j + 1 < length && chars[j] == chars[j + 1]) {
                count++;
                j++;
            }
            if (count >= 2) {
                tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                res.add(tmp);
            }
            i = j == i ? i + 1 : j;
        }
        return res;
    }

}
