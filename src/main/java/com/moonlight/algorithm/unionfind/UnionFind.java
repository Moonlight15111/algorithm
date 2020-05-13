package com.moonlight.algorithm.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName UnionFind
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/13 22:23
 * @Version V1.0
 **/
public class UnionFind {
    static class UnionSet<V>{
        // val V 与其包装结点Node<V>的映射Map
        private HashMap<V, Node<V>> nodes = new HashMap<>();
        // 存放每个包装结点Node<V>与其父结点的映射Map
        private HashMap<Node<V>, Node<V>> parents = new HashMap<>();
        // 存放代表结点中代表了多少包装结点的映射Map
        private HashMap<Node<V>, Integer> sizes = new HashMap<>();

        public UnionSet(V[] values){
            for (V val : values) {
                Node<V> nodeV = new Node<>(val);
                nodes.put(val, nodeV);
                parents.put(nodeV, nodeV);
                sizes.put(nodeV, 1);
            }
        }

        //  找到代表点
        public Node<V> findParent (Node<V> current) {
            Stack<Node<V>> stack = new Stack<>();
            while (current != parents.get(current)) {
                stack.add(current);
                current = parents.get(current);
            }
            // 对并查集进行优化：将链表扁平化，减少树的高度。虽然这边会改变结构，但是对于并查集来说
            // 除了最终的代表元以外其他父结点都是没啥意义的，有没有无所谓。
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), current);
            }
            return current;
        }

        public boolean isSameSet(V a, V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findParent(nodes.get(a)) == findParent(nodes.get(b));
        }

        public void union (V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> nodeAParent = findParent(nodes.get(a)), nodeBParent = findParent(nodes.get(b));

            if (nodeAParent != nodeBParent) {
                Node<V> largest = sizes.get(nodeAParent) >= sizes.get(nodeBParent) ? nodeAParent : nodeBParent;
                Node<V> small = largest == nodeAParent ? nodeBParent : nodeAParent;
                parents.put(small, largest);
                sizes.put(largest, sizes.get(largest) + sizes.get(small));
                sizes.remove(small);
            }
        }

        public int getMetaSize () {
            return sizes.size();
        }
    }

    static class Node<V>{
        private V val;
        public Node(V val){
            this.val = val;
        }
    }
}
