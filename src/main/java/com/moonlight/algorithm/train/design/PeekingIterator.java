package com.moonlight.algorithm.train.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/peeking-iterator/
 *
 * 请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
 * 实现 PeekingIterator 类：
 *     PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
 *     int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 *     bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 *     int peek() 返回数组中的下一个元素，但 不 移动指针。
 *
 * 输入：
 * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出：
 * [null, 1, 2, 2, 3, false]
 *
 * 解释：
 * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
 * peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,2,3]
 * peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,2,3]
 * peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,3]
 * peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
 * peekingIterator.hasNext(); // 返回 False
 *
 *
 * @ClassName PeekingIterator
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/5 11:20
 * @Version V1.0
 **/
public class PeekingIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        Iterator<Integer> iterator = new Iterator<Integer>() {
            int[] a = {1, 2, 3};
            int idx = 0;
            @Override
            public boolean hasNext() {
                return idx < a.length;
            }

            @Override
            public Integer next() {
                return a[idx++];
            }
        };
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        // 返回 1 ，指针移动到下一个元素
        System.out.println(peekingIterator.next());
        // 返回 2 ，指针未发生移动
        System.out.println(peekingIterator.peek());
        // 返回 2 ，指针移动到下一个元素
        System.out.println(peekingIterator.next());
        // 返回 3 ，指针移动到下一个元素
        System.out.println(peekingIterator.next());
        // 返回 False
        System.out.println(peekingIterator.hasNext());
    }

    private List<Integer> list;
    private int idx;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        idx = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(idx);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }

}
