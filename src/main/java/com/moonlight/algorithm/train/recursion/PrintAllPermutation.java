package com.moonlight.algorithm.train.recursion;

import java.util.ArrayList;
import java.util.List;
/**
 * 字符串全排列
 * @ClassName PrintAllPermutation
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/2 13:31
 * @Version V1.0
 **/
public class PrintAllPermutation {

    public static void main(String[] args) {
        String abc = "abc";
        for (String s : permutation(abc)) {
            System.out.println(s);
        }
    }

    public static List<String> permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        if (str.length() == 0) {
            res.add(str);
            return res;
        }
        char[] chars = str.toCharArray();
        process(chars, 0, res);
        return res;
    }

    private static void process(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
            res.add(String.valueOf(chars));
        }
        // index 及其以后的位置都有机会来到index位置
        for (int i = index, length = chars.length; i < length; i++) {
            swap(chars, i, index);
            process(chars, index + 1, res);
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int index) {
        char tmp = chars[i];
        chars[i] = chars[index];
        chars[index] = tmp;
    }

}
