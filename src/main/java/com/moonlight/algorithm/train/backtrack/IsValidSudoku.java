package com.moonlight.algorithm.train.backtrack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *    数字 1-9 在每一行只能出现一次。
 *    数字 1-9 在每一列只能出现一次。
 *    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * @author Moonlight
 * @date 2021/3/18 17:15
 */
public class IsValidSudoku {

    public static void main(String[] args) {
		char[][] a = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}},

                b = {{'8','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(a) + ", " + violenceSearch(a));
        System.out.println(isValidSudoku(b) + ", " + violenceSearch(b));
    }
	
	public static boolean violenceSearch(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !valid(i, j, board[i][j], board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(int r, int c, char ch, char[][] board) {
        // row
        for (int i = r + 1; i < 9; i++) {
            if (board[i][c] == ch) {
                return false;
            }
        }
        // col
        for (int i = c + 1; i < 9; i++) {
            if (board[r][i] == ch) {
                return false;
            }
        }
        // 当前属于哪个3 * 3的区域 rr = reg row  rc = reg col
        int rr = (r / 3) * 3, rc = (c / 3) * 3;

        for (int i = rr; i < rr + 3; i++) {
            for (int j = rc; j < rc + 3; j++) {
                if (board[i][j] == ch && (i != r && j != c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], regions = new boolean[9][9];
        int region, num;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    num = board[i][j] - '1';
                    // i 所在宫相对于第 0 宫下移了 i / 3 个宫，
                    // 又 一个宫占 3 行，故: (i / 3) * 3, 由此可得 i 所在宫的 第 0 格的行
                    // 对于宫里面的格子 j ，又相对于所在宫的第 0 格下移了 j / 3 行
                    // 故：i j 所在格行为 - (i / 3) * 3 + j / 3
                    region = (i / 3) * 3 + j / 3;
                    if (rows[i][num] || cols[j][num] || regions[region][num]) {
                        return false;
                    }
                    rows[i][num] = true;
                    cols[j][num] = true;
                    regions[region][num] = true;
                }
            }
        }
        return true;
    }
}
