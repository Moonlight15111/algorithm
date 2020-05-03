package com.moonlight.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lru
 * @Description: LRU(Least Recently Used 最不常用)
 * @Author Moonlight
 * @Date 2020/4/30 23:26
 * @Version V1.0
 **/
public class Lru<T> {
    private Map<String, Node<T>> lruListMap = new HashMap<>();
    private Node<T> head, tail;

    public void put(String key, T val){
        if (this.head == null) {
            Node<T> node = new Node<>(val);
            this.head = node;
            this.tail = node;
            lruListMap.put(key, node);
            return;
        }

        Node<T> node = lruListMap.get(key);
        if (node != null) {
            node.data = val;
            Node<T> prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;
        } else {
            node = new Node<>(val);
        }
        moveToTail(key, node);
    }

    private void moveToTail(String key, Node<T> node){
        node.prev = this.tail;
        this.tail.next = node;
        this.tail = node;
        lruListMap.put(key, node);
    }

    public T get(String key){
        return lruListMap.get(key) == null ? null : lruListMap.get(key).data;
    }



    static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T data;

        public Node(T cacheData){
            this.data = cacheData;
        }
    }
}
