package com.moonlight.algorithm.train.dp;

/**
 * 在范围上尝试的模型
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明
 * 请返回最后获胜者的分数。
 * @ClassName CardsInLine
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/4 21:52
 * @Version V1.0
 **/
public class CardsInLine {

    public static void main(String[] args) {
        int[] arr = {1, 100, 1};
        System.out.println(win(arr));
        System.out.println(dp(arr));
    }

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    private static int first(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        // 先手可以取left或right位置，然后变成后手，就只能从 left + 1 到 right 或 left 到 right - 1
        return Math.max(arr[left] + second(arr, left + 1, right), arr[right] + second(arr, left, right - 1));
    }

    private static int second(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        // 后手变先手，只能从 left + 1 到 right 或 left 到 right - 1 取最小的，因为先手必不可能给后手留大牌
        return Math.min(first(arr, left + 1, right), first(arr, left, right - 1));
    }

    public static int dp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[][] first = new int[len][len];
        int[][] second = new int[len][len];

        for (int i = 0; i < len; i++) {
            first[i][i] = arr[i];
        }

        for (int i = 1; i < len; i++) {
            int row = 0;
            int col = i;
            while (row < len && col < len) {
                first[row][col] = Math.max(arr[row] + second[row + 1][col], arr[col] + second[row][col - 1]);
                second[row][col] = Math.min(first[row + 1][col], first[row][col - 1]);
                row++;
                col++;
            }
        }

        return Math.max(first[0][len - 1], second[0][len - 1]);
    }
}
