package com.moonlight.algorithm.train.slidingwindowdoubleptr;

import java.util.LinkedList;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/submissions/
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * @author Moonlight
 * @date 2021/1/12 16:21
 */
public class MaxQueue {

    private LinkedList<Integer> dataList;
    private LinkedList<Integer> maxList;

    public MaxQueue() {
        dataList = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        return maxList.isEmpty() ? -1 : maxList.peekFirst();
    }

    private void addMax(int val) {
        while (!maxList.isEmpty() && maxList.peekLast() < val) {
            maxList.pollLast();
        }
        maxList.addLast(val);
    }

    public void push_back(int value) {
        dataList.addLast(value);
        addMax(value);
    }

    public int pop_front() {
        int res = dataList.isEmpty() ? -1 : dataList.pollFirst();
        if (res == max_value()) {
            maxList.pollFirst();
        }
        return res;
    }

}
