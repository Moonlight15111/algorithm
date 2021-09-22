package com.moonlight.algorithm.train.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @ClassName DiffWaysToCompute
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/19 12:07
 * @Version V1.0
 **/
public class DiffWaysToCompute {

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i + 1));
                for (Integer li : l) {
                    for (Integer lr : r) {
                        if (c == '+') {
                            ans.add(li + lr);
                        } else if (c == '-') {
                            ans.add(li - lr);
                        } else {
                            ans.add(li * lr);
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }

}
