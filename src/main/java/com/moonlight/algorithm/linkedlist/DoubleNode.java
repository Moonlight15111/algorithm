package com.moonlight.algorithm.linkedlist;

/**
 * @ClassName DoubleNode
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/2 21:32
 * @Version V1.0
 **/
public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> next, prev;

    public DoubleNode(T data) {
        this.data = data;
    }
}
