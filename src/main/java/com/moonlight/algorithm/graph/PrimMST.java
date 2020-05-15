package com.moonlight.algorithm.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName PrimMST
 * @Description: prim算法求最小生成树
 * @Author Moonlight
 * @Date 2020/5/15 22:31
 * @Version V1.0
 **/
public class PrimMST {

    // 最开始将所有的边/点都视作未解锁状态
    // 从任意节点出发，可以解锁出发节点的所有边及直接邻居节点
    // 选取已解锁边中权重最小的边，如果它
    public static Set<Edge> primMST(Graph graph){
        Set<Edge> result = new HashSet<>();
        // 解锁的节点
        Set<Node> unlockNodes = new HashSet<>();
        // 边的小根堆
        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

        Edge poll;
        Node edgeTo;
        // 防止出现森林的情况
        for (Node startNode : graph.nodes.values()) {
            if (!unlockNodes.contains(startNode)) {
                unlockNodes.add(startNode);

                edgePriorityQueue.addAll(startNode.edges);

                while (!edgePriorityQueue.isEmpty()) {
                    poll = edgePriorityQueue.poll();
                    edgeTo = poll.to;
                    if (!unlockNodes.contains(edgeTo)) {
                        unlockNodes.add(edgeTo);
                        result.add(poll);
                        edgePriorityQueue.addAll(edgeTo.edges);
                    }
                }
            }
        }
        return result;
    }

}
