package com.moonlight.algorithm.graph;

import java.util.*;

/**
 * @ClassName KruskalMST
 * @Description: Kruskal算法求最小生成树
 * @Author Moonlight
 * @Date 2020/5/15 21:51
 * @Version V1.0
 **/
public class KruskalMST {

    // 从权值最小的边开始考虑，通过并查集的方式，查询边的两端是否在一个集合中(即是否为连通的)
    // 如果不是一个集合那么就合并, 保留这条边
    // 如果是无向图，最后是会出现缺一半的情况的
    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind(graph.nodes.values());
        // 先将边通过权值进行从小到大进行排序
        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        Set<Edge> result = new HashSet<>();

        edgePriorityQueue.addAll(graph.edges);

        Edge cur;
        while (!edgePriorityQueue.isEmpty()) {
            cur = edgePriorityQueue.poll();
            if (!unionFind.isSameSet(cur.from, cur.to)) {
                result.add(cur);
                unionFind.union(cur.from, cur.to);
            }
        }
        return result;
    }


    static class UnionFind{
        public Map<Node, Node> parentMap = new HashMap<>();
        public Map<Node, Integer> sizeMap = new HashMap<>();

        public UnionFind (Collection<Node> nodes) {
            for (Node node : nodes) {
                parentMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node){
            Stack<Node> stack = new Stack<>();

            Node result = node;
            while (parentMap.get(result) != null) {
                stack.add(result);
                result = parentMap.get(result);
            }

            // 扁平优化
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), result);
            }

            return result;
        }

        public boolean isSameSet(Node nodeA, Node nodeB){
            if (nodeA == null || nodeB == null) {
                return false;
            }
            return findFather(nodeA) == findFather(nodeB);
        }

        public void union(Node nodeA, Node nodeB){
            if (nodeA == null || nodeB == null || !parentMap.containsKey(nodeA) || !parentMap.containsKey(nodeB)) {
                return;
            }

            Node aParent = findFather(nodeA), bParent = findFather(nodeB);

            if (aParent != bParent) {
                int aParentSize = sizeMap.get(aParent), bParentSize = sizeMap.get(bParent);
                Node largest = aParentSize > bParentSize ? aParent : bParent;
                Node small = largest == aParent ? bParent : aParent;
                parentMap.put(small, largest);
                sizeMap.put(largest, aParentSize + bParentSize);
                sizeMap.remove(small);
            }
        }
    }
}
