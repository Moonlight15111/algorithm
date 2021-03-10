package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 原题：https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3  输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 输入：n = 1  输出：["()"]
 *
 * @ClassName GenerateParenthesis
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/28 17:52
 * @Version V1.0
 **/
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(" ================================ ");

        List<String> stringList = generateParenthesis(1);
        for (String str : stringList) {
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        // 每个 ( 都必须对应一个 ) 所以左括号总数和右括号总数是有规律的
        // 左右括号并没有要求要一对一对的加，所以我设定我必须先添加左括号，
        // 那么在这种情况下，左括号的总数是一定会小于等于右括号的总数的
        if (n < 1) {
            return res;
        }

        if (n == 1) {
            res.add("()");
            return res;
        }

        generateParenthesis(res, "", n, n);

        return res;
    }

    public static void generateParenthesis(List<String> res, String string, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(string);
         } else if (left == right) {
            generateParenthesis(res, string + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                generateParenthesis(res, string + "(", left - 1, right);
            }
            generateParenthesis(res, string + ")", left, right - 1);
        }
    }

}
