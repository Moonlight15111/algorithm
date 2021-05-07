package com.moonlight.algorithm.train.couldnotworkout;

/**
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 *   升级水桶：选择任意一个水桶，使其容量增加为 bucket[i] + 1
 *   蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 *
 * 输入：bucket = [1, 3], vat = [6, 8]
 * 输出：4
 * 解释：
 *   第 1 次操作升级 bucket[1]；
 *   第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 *
 * 输入：bucket = [9, 0, 1], vat = [0, 2, 2]
 * 输出：3
 * 解释：
 *   第 1 次操作均选择升级 bucket[1]
 *   第 2~3 次操作选择蓄水，即可完成蓄水要求。
 *
 * @author Moonlight
 * @date 2021/4/10 15:04
 */
public class StoreWater {

    public static void main(String[] args) {
        int[] a = {1, 3}, b = {6, 8};
        // 4
        System.out.println(storeWater(a, b));
        int[] c = {9, 0, 1}, d = {0, 2, 2};
        // 3
        System.out.println(storeWater(c, d));
        int[] e = {2, 2, 2}, f = {1, 2, 5};
        // 3
        System.out.println(storeWater(e, f));
        int[] g = {0, 0, 0}, h = {2, 6, 2};
        // 9
        System.out.println(storeWater(g, h));
    }

    public static int storeWater(int[] bucket, int[] vat) {
        // 1. 如果该水桶的容量为0，这种情况下一次升级操作是必不可少的，同时升级容量只能 + 1，所以这个位置需要取 vat[i]
//        int res = 0, count = 0;
//        for (int i = 0; i < bucket.length; i++) {
//            if (bucket[i] != 0) {
//                int op = (int)Math.ceil((double)vat[i] / (double)bucket[i]);
//                int upgrade = (int)Math.ceil((double)vat[i] / (double)(bucket[i] + 1));
//                res = Math.max(res, Math.min(op, upgrade + 1));
//            } else {
//                int upgradeCount = 1;
//                int op = (int)Math.ceil((double)vat[i] / (double)upgradeCount);
//                while (op >= vat[i]) {
//                    upgradeCount++;
//                    op = (int)Math.ceil((double)vat[i] / (double)upgradeCount);
//                }
//                count += upgradeCount + op;
//            }
//        }
//        return res + count;
        return 0;
    }

}
