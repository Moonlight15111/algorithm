package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/permutation-sequence/
 *
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 输入：n = 3, k = 3  输出："213"
 *
 * 输入：n = 4, k = 9  输出："2314"
 *
 * 输入：n = 3, k = 1  输出："123"
 *
 * @ClassName PermutationSequence
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/13 12:32
 * @Version V1.0
 **/
public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 1) + ", " + getPermutation123(3, 1));
        System.out.println(getPermutation(3, 3) + ", " + getPermutation123(3, 3));
        System.out.println(getPermutation(4, 9) + ", " + getPermutation123(4, 9));
        System.out.println(getPermutation(9, 233794) + ", " + getPermutation123(9, 233794));
    }

    public static String getPermutation123(int n, int k) {
        if (n < 1 || k < 1) {
            return null;
        }
        // 康托展开，参考：https://zhuanlan.zhihu.com/p/143407008
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        
        StringBuilder res = new StringBuilder();
        k -= 1;

        for (int i = 0; i < n; i++) {
            int factorial = getFactorial(n - i - 1);
            int index = k / factorial;
            res.append(list.get(index));
            k %= factorial;
            list.remove(index);
        }

        return res.toString();
    }

    public static int getFactorial(int x) {
        if (x == 0)
            return 1;
        int res = x;
        for (int i = 1; i < x; i++) {
            res *= i;
        }
        return res;
    }

    public static String getPermutation(int n, int k) {
        if (n < 1 || k < 1) {
            return null;
        }
        // time out
        boolean[] visited = new boolean[n + 1];
        List<String> res = new ArrayList<>();
        backtrack(n, new StringBuilder(), visited, res);
        return res.get(k - 1);
    }

    private static void backtrack(int n, StringBuilder stringBuilder, boolean[] visited, List<String> res) {
        if (stringBuilder.length() == n) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                stringBuilder.append(i);
                visited[i] = true;
                backtrack(n, stringBuilder, visited, res);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                visited[i] = false;
            }
        }
    }

}
