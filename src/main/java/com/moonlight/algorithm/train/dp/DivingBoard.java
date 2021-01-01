package com.moonlight.algorithm.train.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/diving-board-lcci/
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * @ClassName DivingBoard
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/1 20:02
 * @Version V1.0
 **/
public class DivingBoard {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divingBoard(1, 2, 3)));
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        // 返回的结果必定有 k + 1 个
        // 假设拿了 i 个longer，则shorter必为 k - i，则 f(i) = longer * i + shorter * (k - i) ==> longer * i + shorter * k - shorter * i
        // ==> shorter * k + (longer - shorter) * i ==> 又longer - shorter >= 0, 所以f(i)为一个随着i增长单调递增的一元线性函数, 且0 <= i <= k, f(i) 必有 k + 1 个不同的取值
        int[] arr = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            arr[i] = (shorter * (k - i)) + (longer * i);
        }

        return arr;
    }

}
