package com.moonlight.algorithm.train.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/camelcase-matching/
 *
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，
 * 那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。
 * 只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 *
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 * @author Moonlight
 */
public class CamelMatch {

    public static void main(String[] args) {
        System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
        System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        // 一个一个循环匹配就好
        // 只需要注意 pattern 和 q 中不能出现彼此都没有的大写字母就好
        for (String q : queries) {
            ans.add(match(q, pattern));
        }
        return ans;
    }

    private static Boolean match(String q, String pattern) {
        int idx = 0;
        for (char c : q.toCharArray()) {
            if (idx == pattern.length() && c < 'a') {
                return false;
            }
            if (idx < pattern.length() && pattern.charAt(idx) == c) {
                idx++;
            } else if (c < 'a') {
                return false;
            }
        }
        return idx == pattern.length();
    }
}
