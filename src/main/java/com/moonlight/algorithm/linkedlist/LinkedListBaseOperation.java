package com.moonlight.algorithm.linkedlist;

/**
 * @ClassName SingleNodeList
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/2 21:31
 * @Version V1.0
 **/
public class LinkedListBaseOperation<T> {

    public SingleNode<T> reverseSingleLinkedList(SingleNode<T> head){
        SingleNode<T> prev = null, next = null;
        while (head != null) {
            next = head.next;

            head.next = prev;
            prev = head;

            head = next;
        }
        return prev;
    }

    public SingleNode<T> reverseSingleList(SingleNode<T> head){
        if (head.next == null) {
            return head;
        }
        SingleNode<T> res = reverseSingleList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public DoubleNode<T> reverseDoubleNodeLinkedList(DoubleNode<T> head) {
        DoubleNode<T> prev = null, next = null;
        while (head != null) {
            next = head.next;

            // next 往回指  prev往前指 head變成此時的結點
            head.next = prev;
            head.prev = next;
            prev = head;

            head = next;
        }
        return prev;
    }

    // 刪除鏈表中值等於給定數據的結點
    public DoubleNode<T> removeNodeByNodeData(DoubleNode<T> head, T data) {
        // 1.首先需要判斷是否頭結點的值是否等於給定的數據，如果等於那麽就直接捨棄掉當前的頭
        while (head != null) {
            if (head.data != data) {
                break;
            }
            head = head.next;
        }
        // 2.head來到第一個不需要刪除的位置
        DoubleNode<T> prev = head, current = head;
        while (current != null) {
            if (current.data == data) {
                prev.next = current.next;
                current.next.prev = prev;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

}
