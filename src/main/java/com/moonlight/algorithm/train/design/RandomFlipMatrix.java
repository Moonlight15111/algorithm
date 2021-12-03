package com.moonlight.algorithm.train.design;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/random-flip-matrix/
 * <p>
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 * 实现 Solution 类：
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 * <p>
 * Solution solution = new Solution(3, 1);
 * solution.flip();  // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * solution.flip();  // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
 * solution.flip();  // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
 * solution.reset(); // 所有值都重置为 0 ，并可以再次选择下标返回
 * solution.flip();  // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同  
 *
 * @ClassName RandomFlipMatrix
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/27 11:20
 * @Version V1.0
 **/
public class RandomFlipMatrix {

    public static void main(String[] args) {
        RandomFlipMatrix solution = new RandomFlipMatrix(3, 1);
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        solution.reset();
        System.out.println(Arrays.toString(solution.flip()));
    }

    int m, n;
    Set<Integer> set;
    Random random;

    public RandomFlipMatrix(int m, int n) {
        this.set = new HashSet<>();
        this.m = m;
        this.n = n;
        this.random = new Random();
    }

    public int[] flip() {
        int res = random.nextInt(m * n);
        while (set.contains(res)) {
            res = random.nextInt(m * n);
        }
        set.add(res);
        return new int[]{res / n, res % n};
    }

    public void reset() {
        this.set.clear();
    }

}
