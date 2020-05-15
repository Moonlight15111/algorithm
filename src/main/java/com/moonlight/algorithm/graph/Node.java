package com.moonlight.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Node
 * @Description: 图的点描述结构
 * @Author Moonlight
 * @Date 2020/5/14 20:56
 * @Version V1.0
 **/
public class Node {
    // 点的值
    public int val;
    // 点的入度
    public int in;
    // 点的出度
    public int out;
    // 点的直接邻居（出度的才算做直接邻居, 即直接指向的点算做直接邻居）
    public List<Node> nexts;
    // 从这个点出发的边
    public List<Edge> edges;

    public Node(int val){
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

}
