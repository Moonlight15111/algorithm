package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/
 *
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 输入：n = 3, k = 7    输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 *
 * 输入：n = 2, k = 1    输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 * 输入：n = 2, k = 0    输出：[11,22,33,44,55,66,77,88,99]
 *
 * 输入：n = 2, k = 2    输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 *
 * 2 <= n <= 9
 * 0 <= k <= 9
 *
 * @author Moonlight
 * @date 2021/3/18 11:25
 */
public class NumsSameConsecDiff {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 0)));
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 2)));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<Integer>(), list);

        int[] res = new int[list.size()];

        int index = 0, num;
        for (List<Integer> integers : list) {
            num = 0;
            for (Integer i : integers) {
                num = num * 10 + i;
                res[index] = num;
            }
            index++;
        }

        return res;
    }

    private static void backtrack(int index, int n, int k, ArrayList<Integer> path, List<List<Integer>> res) {
        if (index > n) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 第一个数字，可以从1 到 9
        if (index == 1) {
            for (int i = 1; i <= 9; i++) {
                path.add(i);
                backtrack(index + 1, n, k, path, res);
                path.remove(path.size() - 1);
            }
        } else {
            Integer integer = path.get(path.size() - 1);
            if (integer + k <= 9) {
                path.add(integer + k);
                backtrack(index + 1, n, k, path, res);
                path.remove(path.size() - 1);
            }
            if (k != 0 && integer - k >= 0) {
                path.add(integer - k);
                backtrack(index + 1, n, k, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}