package com.moonlight.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName BreadthFirstSearch
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/14 22:14
 * @Version V1.0
 **/
public class BreadthFirstSearch {

    public static void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> nodes = new HashSet<>();

        queue.add(node);
        nodes.add(node);

        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.println(cur.val);
            for (Node n : node.nexts) {
                if (!nodes.contains(n)) {
                    queue.add(n);
                    nodes.add(n);
                }
            }
        }
    }

}
