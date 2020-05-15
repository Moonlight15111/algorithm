package com.moonlight.algorithm.graph;

/**
 * @ClassName Edge
 * @Description: 边的结构描述
 * @Author Moonlight
 * @Date 2020/5/14 21:00
 * @Version V1.0
 **/
public class Edge {
    // 边的权重
    public int weight;
    // 边的起点
    public Node from;
    // 边的终点
    public Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
