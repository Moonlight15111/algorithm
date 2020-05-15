package com.moonlight.algorithm.graph;

import java.util.*;

/**
 * @ClassName TopologySort
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/14 23:15
 * @Version V1.0
 **/
public class TopologySort {

    public static List<Node> topologySort(Graph graph){
        List<Node> result = new LinkedList<>();
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 1.先获取入度为0的点
        for (Node node : graph.nodes.values()) {
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
            inMap.put(node, node.in);
        }
        // 2.将其从图中擦除，并消除它对其它点的入度影响
        // 3.循环此过程，返回最终结果
        Node cur;
        while (!zeroInQueue.isEmpty()) {
            cur = zeroInQueue.poll();
            result.add(cur);

            for (Node node : cur.nexts) {
                inMap.put(node, inMap.get(node) - 1);
                if (inMap.get(node) == 0) {
                    zeroInQueue.add(node);
                }
            }
        }

        return result;
    }

}
