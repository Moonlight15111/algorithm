package com.moonlight.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Graph
 * @Description: 图的结构描述
 * @Author Moonlight
 * @Date 2020/5/14 21:02
 * @Version V1.0
 **/
public class Graph {
    // 点集
    public Map<Integer, Node> nodes;
    // 边集
    public Set<Edge> edges;

    public Graph(){
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public void buildGraph(Integer[][] data){
        if (data == null || data.length <= 0) {
            return;
        }
        for (Integer[] arr : data) {
            Integer weight = arr[0], from = arr[1], to = arr[2];

            Node fromNode = new Node(from), toNode = new Node(to);
            if (!this.nodes.containsKey(from)) {
                this.nodes.put(from, fromNode);
            }
            if (!this.nodes.containsKey(to)) {
                this.nodes.put(to, toNode);
            }
            fromNode = this.nodes.get(from);
            toNode = this.nodes.get(to);

            Edge edge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            fromNode.out++;

            toNode.in++;

            this.edges.add(edge);
        }
    }

}
