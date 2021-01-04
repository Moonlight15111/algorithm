package com.moonlight.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/10 23:00
 * @Version V1.0
 **/
public class Test {

    public static void main (String[] args) {
        String[] arr = {"s", "k", "x"};
        Set<Integer> use = new HashSet<>();
        String path = "";
        List<String> result = new ArrayList<>();
        process(arr, use, path, result);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void process (String[] strs, Set<Integer> usePos, String path, List<String> result) {
        if (usePos.size() == strs.length) {
            result.add(path);
        } else {
            for (int i = 0, length = strs.length; i < length; i++) {
                if (!usePos.contains(i)) {
                    usePos.add(i);
                    process(strs, usePos, path + strs[i], result);
                    usePos.remove(i);
                }
            }
        }
    }

    public static int fib (int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0, second = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

}
