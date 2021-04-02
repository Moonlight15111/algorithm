package com.moonlight.algorithm.train.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * @ClassName PascalsTriangleII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/2 22:51
 * @Version V1.0
 **/
public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(5));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> tmp;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return res.get(rowIndex);
    }
}
