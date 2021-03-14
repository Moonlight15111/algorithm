package com.moonlight.algorithm.train.other;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 *
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 *   void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 *   int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 *   void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * @ClassName MyHashMap
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/14 10:29
 * @Version V1.0
 **/
public class MyHashMap {

    private List<Entry> list;

    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new LinkedList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        for (Entry entry : list) {
            if (entry.key == key) {
                entry.val = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for (Entry entry : list) {
            if (entry.key == key) {
                return entry.val;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        list.removeIf(entry -> entry.key == key);
    }

    private static class Entry {
        int key;
        int val;
        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
