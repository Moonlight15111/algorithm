package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数以生成n个小括号，和m个大括号，要求输出格式正确的括号的所有组合。  例如，
 * 输入：n = 1，m=1
 * 输出： ({}), (){}, {}(), {()}
 *
 * 输入：n = 2，m=1
 * 输出：{}()(), {()}(),{()()}, ({})(),(){}(), (){()}, ()({}), ()(){}, {}(()), {(())}, ({}()), ({()}), (({})), ((){}), (()){}
 *
 * @ClassName BracketIII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/6 21:39
 * @Version V1.0
 **/
public class BracketIII {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1, 1));
        System.out.println(generateParenthesis(2, 1));
    }

    public static List<String> generateParenthesis(int n, int m) {
        List<String> res = new ArrayList<>();

        generateParenthesis(n, n, m, m, new StringBuilder(), false, res);
        generateParenthesis(n, n, m, m, new StringBuilder(), true, res);

        return res;
    }

    private static void generateParenthesis(int ln, int rn, int lm, int rm, StringBuilder path, boolean isBig, List<String> res) {
        if (ln < 0 || rn < 0 || lm < 0 || rm < 0) {
            return;
        }
        if (ln == 0 && rn == 0 && lm == 0 && rm == 0) {
            res.add(path.toString());
            return;
        }

    }


}
