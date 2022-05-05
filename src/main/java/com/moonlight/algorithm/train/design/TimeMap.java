package com.moonlight.algorithm.train.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/time-based-key-value-store/
 *
 * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
 *
 * 实现 TimeMap 类：
 *   TimeMap() 初始化数据结构对象
 *   void set(String key, String value, int timestamp) 存储键 key、值 value，以及给定的时间戳 timestamp。
 *   String get(String key, int timestamp)
 *   返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp 。
 *   如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 *   如果没有值，则返回空字符串（""）。
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1  
 * timeMap.get("foo", 1);         // 返回 "bar"
 * timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
 * timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4 
 * timeMap.get("foo", 4);         // 返回 "bar2"
 * timeMap.get("foo", 5);         // 返回 "bar2"
 *
 * @author Moonlight
 * @date 2022-05-05 16:38
 */
public class TimeMap {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }

    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key) && map.get(key).floorKey(timestamp) != null) {
            return map.get(key).get(map.get(key).floorKey(timestamp));
        }
        return "";
    }

}
