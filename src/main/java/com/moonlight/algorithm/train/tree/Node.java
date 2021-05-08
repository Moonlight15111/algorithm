package com.moonlight.algorithm.train.tree;

import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2021/5/8 11:46
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
