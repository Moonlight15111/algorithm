package com.moonlight.algorithm.train.design;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/continuous-median-lcci/
 *
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 */
public class MedianFinder {

    private PriorityQueue<Integer> small, big;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (small.size() != big.size()) {
            big.add(num);
            small.add(big.poll());
        } else {
            small.add(num);
            big.add(small.poll());
        }
    }

    public double findMedian() {
        return big.size() != small.size() ? big.peek() : (big.peek() + small.peek()) / 2.0;
    }

}
