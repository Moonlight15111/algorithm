package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 *
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，
 * 其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，
 * 我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，
 * 使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 *
 * 输入：s = "(()())(())"  输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 * 输入：s = "(()())(())(()(()))"  输出："()()()()(())"
 *
 * 输入：s = "()()"  输出：""
 *
 * @ClassName RemoveOuterParentheses
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/15 11:55
 * @Version V1.0
 **/
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                cnt--;
            }
            if (cnt >= 1) {
                ans.append(c);
            }
            if (c == '(') {
                cnt++;
            }
        }
        return ans.toString();
    }
}
