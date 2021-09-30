package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @ClassName ReplaceSpace
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/30 22:40
 * @Version V1.0
 **/
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char value : s.toCharArray()) {
            if (value == ' ') {
                sb.append("%20");
            } else {
                sb.append(value);
            }
        }
        return sb.toString();
    }

}
