package com.moonlight.algorithm.train;

import java.util.Objects;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/17 14:39
 */
public class CrawlerLogFolder {

    public static void main(String[] args) {
        // 2
        String[] s = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(s));
        System.out.println(minOperations2(s));
        // 3
        String[] ss = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(minOperations(ss));
        System.out.println(minOperations2(ss));
        // 0
        String[] sss = {"d1/", "../", "../", "../"};
        System.out.println(minOperations(sss));
        System.out.println(minOperations2(sss));
    }

    public static int minOperations2(String[] logs) {
        if (logs == null || logs.length < 1) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (String s : logs) {
            if (Objects.equals(s, "./")) {
                continue;
            }
            if (Objects.equals(s, "../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        return stack.size();
    }

    public static int minOperations(String[] logs) {
        if (logs == null || logs.length < 1) {
            return 0;
        }
        int count = 0;
        for (String s : logs) {
            if (Objects.equals(s, "./")) {
                continue;
            }
            if (Objects.equals(s, "../")) {
                count = count > 0 ? count - 1 : count;
            } else {
                count ++;
            }
        }
        return count;
    }

}
