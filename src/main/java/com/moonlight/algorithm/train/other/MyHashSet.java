package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MyHashSet
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/13 11:29
 * @Version V1.0
 **/
public class MyHashSet {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));; // 返回 True
        System.out.println(myHashSet.contains(3));; // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));; // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));; // 返回 False ，（已移除）
    }

    private List<Integer> list;

    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!contains(key)) {
            list.add(key);
        }
//        System.out.println("add: " + list);
    }

    public void remove(int key) {
        if (contains(key)) {
            list.removeIf(e -> e.equals(key));
        }
//        System.out.println("remove: " + list);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }

}
