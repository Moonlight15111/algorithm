package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 详见: https://baike.baidu.com/item/%E6%9D%A8%E8%BE%89%E4%B8%89%E8%A7%92/215098?fr=aladdin
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @ClassName PascalsTriangle
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/31 22:48
 * @Version V1.0
 **/
public class PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (List<Integer> list : generate){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  res = new ArrayList<>();
        List<Integer> tmp;
        if (numRows == 1) {
            tmp = new ArrayList<>();
            tmp.add(1);
            res.add(tmp);
            return res;
        }

        for (int i = 0; i < numRows; i++) {
            tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(tmp);
        }

        return res;
    }

}
