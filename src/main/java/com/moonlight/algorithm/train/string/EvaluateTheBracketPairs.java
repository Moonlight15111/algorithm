package com.moonlight.algorithm.train.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/evaluate-the-bracket-pairs-of-a-string/
 *
 * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 * 将 keyi 和括号用对应的值 valuei 替换。
 * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
 * 请你返回替换 所有 括号对后的结果字符串。
 *
 * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * 输出："bobistwoyearsold"
 * 解释：
 * 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
 * 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
 *
 * 输入：s = "hi(name)", knowledge = [["a","b"]]
 * 输出："hi?"
 * 解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
 *
 * 输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
 * 输出："yesyesyesaaa"
 * 解释：相同的键在 s 中可能会出现多次。
 * 键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
 * 注意，不在括号里的 "a" 不需要被替换。
 *
 * 输入：s = "(a)(b)", knowledge = [["a","b"],["b","a"]]
 * 输出："ba"
 *
 * @ClassName EvaluateTheBracketPairs
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/28 12:26
 * @Version V1.0
 **/
public class EvaluateTheBracketPairs {

    public static void main(String[] args) {
        System.out.println(evaluate("(name)is(age)yearsold", buildTestData()));
    }

    private static List<List<String>> buildTestData() {
        List<List<String>> res = new ArrayList<>();

        List<String> a = new ArrayList<>();
        a.add("name");
        a.add("bob");

        List<String> b = new ArrayList<>();
        b.add("age");
        b.add("two");

        res.add(a);
        res.add(b);

        return res;
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        // 朴实无华毫无技巧的解法
        // 1.先将knowledge，转换成Map
        // 2.找出()中的key，去Map中匹配
        Map<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();
        int keyCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                keyCount++;
            } else if (c == ')') {
                keyCount--;
                res.append(map.getOrDefault(key.toString(), "?"));
                key = new StringBuilder();
            } else if (keyCount > 0) {
                key.append(c);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
