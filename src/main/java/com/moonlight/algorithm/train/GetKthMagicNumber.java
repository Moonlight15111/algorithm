package com.moonlight.algorithm.train;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。〉
 * 原题：https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 * @author Moonlight
 * @date 2020/6/18 11:34
 */
public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        Set<Long> magicNumbers = new HashSet<>();
        Queue<Long> numberQueue = new PriorityQueue<>();
        numberQueue.add(1L);
        Long val;
        while (true) {
            val = numberQueue.poll();
            if  (!magicNumbers.contains(val)) {
                magicNumbers.add(val);
                numberQueue.add(val * 3);
                numberQueue.add(val * 5);
                numberQueue.add(val * 7);
            }
            if (magicNumbers.size() == k) {
                return val.intValue();
            }
        }
    }
}
