package com.moonlight.algorithm.train.sort;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * [2,3,4] 的中位数是 3   [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *    double findMedian() - 返回目前所有元素的中位数。
 *
 * 输入：["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 *      [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 输入：["MedianFinder","addNum","findMedian","addNum","findMedian"]
 *      [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 */
public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }

    private PriorityQueue<Integer> big, small;
//    private List<Double> list;

    public MedianFinder() {
         big = new PriorityQueue<>();
         small = new PriorityQueue<>((a, b) -> b - a);
//        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (big.size() != small.size()) {
            big.add(num);
            small.add(big.poll());
        } else {
            small.add(num);
            big.add(small.poll());
        }
//        list.add((double) num);
//        list.sort(Double::compareTo);
    }

    public double findMedian() {
        return big.size() == small.size() ? (big.peek() + small.peek()) / 2.0 : big.peek();
//        int size = list.size();
//        if ((size & 1) == 0) {
//            int m1 = (size / 2) - 1, m2 = size / 2;
//            return (list.get(m1) + list.get(m2)) / 2;
//        }
//        return list.get(size / 2);
    }

}
