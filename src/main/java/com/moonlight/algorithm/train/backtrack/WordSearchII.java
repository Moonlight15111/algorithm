package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/word-search-ii/
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 *
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *
 * @author Moonlight
 * @date 2021/3/11 14:20
 */
public class WordSearchII {

    public static void main(String[] args) {
        char[][] a = new char[][] {
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };
        String[] astr = {"oath", "pea", "eat", "rain"};

        char[][] b = new char[][] {
                {'a', 'b'}, {'c', 'd'},
        };
        String[] bstr = {"abcb"};

        System.out.println(findWords(a, astr));

        System.out.println(findWords(b, bstr));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        // 遍历每个单词判断是否符合条件
        // 如果符合条件就加到结果集中，并进行下一个单词的搜索
        boolean eureka;
        for (String word : words) {
            eureka = false;
            for (int i = 0, rowMax = board.length; i < rowMax; i++) {
                for (int j = 0, colMax = board[i].length; j < colMax; j++) {
                    // 如果首字符都不同也就没有搜索的必要了
                    if (board[i][j] == word.charAt(0) && backtrack(i, j, 0, word, board)) {
                        res.add(word);
                        eureka = true;
                        break;
                    }
                }
                if (eureka) {
                    break;
                }
            }
        }

        return res;
    }

    private static boolean backtrack(int row, int col, int index, String word, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(index) != board[row][col]) {
            return false;
        }
        // 处理遍历过的字符
        char tmp = board[row][col];
        board[row][col] = ' ';
        // 四个方向上搜索
        boolean res = backtrack(row + 1, col, index + 1, word, board) || backtrack(row - 1, col, index + 1, word, board)
                || backtrack(row, col + 1, index + 1, word, board) || backtrack(row, col - 1, index + 1, word, board);
        // 还原现场
        board[row][col] = tmp;

        return res;
    }

}
