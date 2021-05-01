package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 现有司机N*2人，调度中心会将所有司机平分给A、B两个区域
 * 第 i 个司机去A可得收入为income[i][0]，
 * 第 i 个司机去B可得收入为income[i][1]，
 * 返回所有调度方案中能使所有司机总收入最高的方案，是多少钱
 *
 * @ClassName DispatchDriver
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 18:41
 * @Version V1.0
 **/
public class DispatchDriver {

    public static void main(String[] args) {
        int N = 10;
        int value = 100;
        int testTime = 500;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N) + 1;
            int[][] matrix = randomMatrix(len, value);
            int ans1 = recursion(matrix);
            int ans2 = memory(matrix);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
            }
        }
        System.out.println("测试结束");
    }

    public static int[][] randomMatrix(int len, int value) {
        int[][] ans = new int[len << 1][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = (int) (Math.random() * value);
            ans[i][1] = (int) (Math.random() * value);
        }
        return ans;
    }

    public static int memory(int[][] income) {
        if (income == null || income.length == 0 || (income.length & 1) != 0) {
            return 0;
        }

        int[][] memory = new int[income.length][income.length];
        for (int[] a : memory) {
            Arrays.fill(a, -1);
        }
        return memory(income, 0, income.length >> 1, memory);
    }

    private static int memory(int[][] income, int index, int rest, int[][] memory) {
        if (index == income.length) {
            return 0;
        }
        if (memory[index][rest] != -1) {
            return memory[index][rest];
        }
        // 只剩下rest号司机，那么说明区域B已经满了，接下来所有的司机应该都来A
        if (income.length - index == rest) {
            return income[index][0] + memory(income, index + 1, rest - 1, memory);
        }
        // 如果A区域的名额已经满了，且还有司机没分配，那么他们应该去B
        if (rest == 0) {
            return income[index][1] + memory(income, index + 1, rest, memory);
        }
        int goA = income[index][0] + memory(income, index + 1, rest - 1, memory);
        int goB = income[index][0] + memory(income, index + 1, rest, memory);

        return Math.max(goA, goB);
    }

    public static int recursion(int[][] income) {
        if (income == null || income.length == 0 || (income.length & 1) != 0) {
            return 0;
        }
        return recursion(income, 0, income.length >> 1);
    }

    // index 当前来到了第 index 号司机   rest 区域A还有多少个名额
    private static int recursion(int[][] income, int index, int rest) {
        if (index == income.length) {
            return 0;
        }
        // 只剩下rest号司机，那么说明区域B已经满了，接下来所有的司机应该都来A
        if (income.length - index == rest) {
            return income[index][0] + recursion(income, index + 1, rest - 1);
        }
        // 如果A区域的名额已经满了，且还有司机没分配，那么他们应该去B
        if (rest == 0) {
            return income[index][1] + recursion(income, index + 1, rest);
        }
        int goA = income[index][0] + recursion(income, index + 1, rest - 1);
        int goB = income[index][0] + recursion(income, index + 1, rest);

        return Math.max(goA, goB);
    }

}
