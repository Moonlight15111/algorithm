package com.moonlight.algorithm.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName DepthFirstSearch
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/14 22:39
 * @Version V1.0
 **/
public class DepthFirstSearch {

    public static void dfs(Node node){
        Stack<Node> stack = new Stack<>();
        Set<Node> nodes = new HashSet<>();

        stack.add(node);
        nodes.add(node);

        System.out.println(node.val);

        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            for (Node n : cur.nexts) {
                if (!nodes.contains(n)) {
                    nodes.add(n);
                    stack.add(cur);
                    stack.add(n);
                    System.out.println(n.val);
                    break;
                }
            }
        }
    }

}
