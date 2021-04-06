package com.moonlight.algorithm.train.other;

/**
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 *
 * 输入：coordinates = "a1"  输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 *
 * 输入：coordinates = "h3"  输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 *
 * 输入：coordinates = "c7"  输出：false
 *
 * @ClassName SquareIsWhite
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/3 22:30
 * @Version V1.0
 **/
public class SquareIsWhite {

    public static void main(String[] args) {
        // false
        System.out.println(squareIsWhite("a1"));
        // true
        System.out.println(squareIsWhite("h3"));
        // false
        System.out.println(squareIsWhite("c7"));
        // false
        System.out.println(squareIsWhite("g1"));
        // true
        System.out.println(squareIsWhite("f7"));
    }

    public static boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a' + 1;
        int row = coordinates.charAt(1) - '1' + 1;
        if (col == row) {
            return false;
        }
        return ((col & 1) == 0 && (row & 1) == 1) || ((col & 1) == 1 && (row & 1) == 0);
    }

}