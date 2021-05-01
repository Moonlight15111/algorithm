package com.moonlight.algorithm.train.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 已知一个消息流会不断地吐出整数 1~N，
 * 但不一定按照顺序依次吐出
 * 如果上次打印的序号为i， 那么当i+1出现时
 * 请打印 i+1 及其之后接收过的并且连续的所有数
 * 直到1~N全部接收并打印完
 * 请设计这种接收并打印的结构
 *
 * @ClassName MsgBox
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 17:20
 * @Version V1.0
 **/
public class MsgBox {

    public static void main(String[] args) {
        MsgBox box = new MsgBox();

        box.receive(2,"B");
        box.receive(1,"A");
        box.receive(4,"D");
        box.receive(5,"E");
        box.receive(7,"G");
        box.receive(8,"H");
        box.receive(6,"F");
        box.receive(3,"C");

    }

    private Map<Integer, Node> head = new HashMap<>();
    private Map<Integer, Node> tail = new HashMap<>();
    private int waitNum = 1;

    public void receive(int num, String info) {
        Node cur = new Node(info);

        head.put(num, cur);
        tail.put(num, cur);

        if (tail.containsKey(num - 1)) {
            tail.get(num - 1).next = cur;
            tail.remove(num - 1);
            head.remove(num);
        }

        if (head.containsKey(num + 1)) {
            cur.next = head.get(num + 1);
            tail.remove(num);
            head.remove(num + 1);
        }
        if (num == waitNum) {
            print();
        }

    }

    private void print() {
        Node cur = head.get(waitNum);
        head.remove(waitNum);
        while (cur != null) {
            System.out.print(cur.info + ", ");
            cur = cur.next;
            waitNum++;
        }
        tail.remove(waitNum - 1);
        System.out.println();
    }

    static class Node {
        String info;
        Node next;
        public Node(String info) {
            this.info = info;
        }
    }

}
