package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * <p>
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * 输入: [[1,1],2,[1,1]]   输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 输入: [1,[4,[6]]]     输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * @author Moonlight
 * @date 2021/3/23 10:51
 */
public class NestedIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        List<NestedInteger> aa = new ArrayList<>();
        aa.add(new impl(1, true, null));
        aa.add(new impl(1, true, null));
        List<NestedInteger> bb = new ArrayList<>(aa);

        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new impl(null, false, aa));
        nestedList.add(new impl(2, true, null));
        nestedList.add(new impl(null, false, bb));

        NestedIterator t = new NestedIterator(nestedList);

        while (t.hasNext()) {
            System.out.print(t.next() + ", ");
        }

    }

    private List<Integer> dataList;

    public NestedIterator(List<NestedInteger> nestedList) {
        dataList = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            process(nestedInteger);
        }
    }

    private void process(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            dataList.add(nestedInteger.getInteger());
            return;
        }
        for (NestedInteger nested : nestedInteger.getList()) {
            process(nested);
        }
    }

    @Override
    public Integer next() {
        return dataList.remove(0);
    }

    @Override
    public boolean hasNext() {
        return !dataList.isEmpty();
    }

    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    public static class impl implements NestedInteger {
        Integer val;
        boolean isInt = false;
        List<NestedInteger> list;
        public impl(Integer val, boolean isInt, List<NestedInteger> list) {
            this.val = val;
            this.isInt = isInt;
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return isInt;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

}
