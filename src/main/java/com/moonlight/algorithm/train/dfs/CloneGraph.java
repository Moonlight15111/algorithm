package com.moonlight.algorithm.train.dfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 *
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 *
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 *
 */
public class CloneGraph {

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3), d = new Node(4);
        List<Node> an = new ArrayList<>(), bn = new ArrayList<>(), cn = new ArrayList<>(), dn = new ArrayList<>();
        an.add(b);an.add(d);
        bn.add(a);bn.add(c);
        cn.add(b);cn.add(d);
        dn.add(a);dn.add(c);

        a.neighbors = an; b.neighbors = bn; c.neighbors = cn; d.neighbors = dn;

        Node n = cloneGraph(a);

        System.out.println();
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> m = new HashMap<>();
        cg(node, m);
        return m.get(node);
    }

    private static Node cg(Node node, Map<Node, Node> m) {
        if (node == null) {
            return null;
        }
        if (m.containsKey(node)) {
            return m.get(node);
        }
        Node cn = new Node(node.val, new ArrayList<>());
        m.put(node, cn);
        for (Node n : node.neighbors) {
            cn.neighbors.add(cg(n, m));
        }
        return cn;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
