package com.moonlight.algorithm.train.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/map-sum-pairs/
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum:
 *    1. MapSum() 初始化 MapSum 对象
 *    2. void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
 *       如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 *    3. int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * 提示:
 *    1. 1 <= key.length, prefix.length <= 50
 *    2. key 和 prefix 仅由小写英文字母组成
 *    3. 1 <= val <= 1000
 *    4. 最多调用 50 次 insert 和 sum
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：[null, null, 3, null, 5]
 * 解释：
 *    MapSum mapSum = new MapSum();
 *     mapSum.insert("apple", 3);
 *     mapSum.sum("ap");           // return 3 (apple = 3)
 *     mapSum.insert("app", 2);
 *     mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 * @author Moonlight
 * @date 2021/5/24 13:07
 */
public class MapSum {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
//        mapSum.insert("apple", 3);
        // return 3 (apple = 3)
//        System.out.println(mapSum.sum("ap"));;
//        mapSum.insert("app", 2);
        // return 5 (apple + app = 3 + 2 = 5)
//        System.out.println(mapSum.sum("ap"));;
        mapSum.insert("a", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("b", 2);
        System.out.println(mapSum.sum("a"));;
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (char c : key.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                Node tmp = new Node();
                cur.map.put(c, tmp);
            }
            cur = cur.map.get(c);
            cur.p++;
        }
        cur.val = val;
        cur.e++;
    }

    public int sum(String prefix) {
        Node cur = root;
        int ans = 0;

        for (char c : prefix.toCharArray()) {
            if (cur.map.containsKey(c)) {
                cur = cur.map.get(c);
            } else {
                return 0;
            }
        }

        if (cur.e > 0) {
            ans += cur.val;
        }

        for (Node node : cur.map.values()) {
            ans += getVal(node);
        }

        return ans;
    }

    private int getVal(Node node) {
        int ans = node.e > 0 ? node.val : 0;
        for (Node n : node.map.values()) {
            ans += getVal(n);
        }
        return ans;
    }

    private static class Node {
        int p;
        int e;
        int val;
        Map<Character, Node> map;

        public Node() {
            this.map = new HashMap<>();
        }
    }

}