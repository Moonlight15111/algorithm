package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/two-city-scheduling/
 *
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。
 * 第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]  输出：110
 * 解释：第一个人去 a 市，费用为 10。 第二个人去 a 市，费用为 30。
 *      第三个人去 b 市，费用为 50。 第四个人去 b 市，费用为 20。
 *      最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * 输出：1859
 *
 * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * 输出：3086
 *
 * @ClassName TwoCitySchedCost
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/30 12:46
 * @Version V1.0
 **/
public class TwoCitySchedCost {

    public static void main(String[] args) {
        int[][] a = {
                {10, 20}, {30, 200}, {400, 50}, {30, 20}
        }, b = {
                {259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}
        }, c = {
                {515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}
        };

        System.out.println(twoCitySchedCost(a));
        System.out.println(twoCitySchedCost(b));
        System.out.println(twoCitySchedCost(c));
    }

    public static int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        // 假设每个人都去A
        // 同时用一个数组保存每个人去B - 去A 的费用差值，表示应该去B的人的额外费用
        // 对费用差值数组排序，并从ans中剔除掉额外费用消费最多的前 costs.length / 2 个人
        int ans = 0;
        int[] b = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            b[i] = costs[i][1] - costs[i][0];
            ans += costs[i][0];
        }
        Arrays.sort(b);
        for (int i = 0; i < costs.length / 2; i++) {
            ans += b[i];
        }
        return ans;
    }

}