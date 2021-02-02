package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/baseball-game/
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 * 输入：ops = ["5","2","C","D","+"]    输出：30
 * 解释： "5" - 记录加 5 ，记录现在是 [5]
 *        "2" - 记录加 2 ，记录现在是 [5, 2]
 *        "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 *        "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 *        "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 *        所有得分的总和 5 + 10 + 15 = 30
 *
 * @author Moonlight
 * @date 2021/2/2 9:58
 */
public class CalPoints {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    public static int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if ("+".equals(str)) {
                Integer pop = stack.pop();
                int i = pop + (stack.isEmpty() ? 0 : stack.peek());
                stack.push(pop);
                stack.push(i);
                res += i;
            } else if ("D".equals(str)) {
               res += stack.push(stack.peek() * 2);
            } else if ("C".equals(str)) {
               res -= stack.pop();
            } else {
                stack.push(Integer.valueOf(str));
                res += Integer.valueOf(str);
            }
        }
        return res;
    }

}