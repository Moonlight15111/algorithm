package com.moonlight.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;
import java.util.List;

/**
 * @ClassName PalindromeList
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/5 14:45
 * @Version V1.0
 **/
public class PalindromeList<T> {

    public static void main(String[] args){
        PalindromeList<Integer> palindromeList = new PalindromeList<>();

        List<SingleNode<Integer>> list = new LinkedList<>();
        list.add(new SingleNode<Integer>(1));
        list.add(new SingleNode<Integer>(2));
        list.add(new SingleNode<Integer>(3));
        list.add(new SingleNode<Integer>(2));
        list.add(new SingleNode<Integer>(1));

        System.out.println(palindromeList.isPalindromeList(list.get(0)));
        System.out.println(palindromeList.isPalindromeListLowSpace(list.get(0)));
        for (SingleNode<Integer> node : list) {
            System.out.print(node.data + ", ");
        }
    }

    /**
     * @Author Moonlight
     * @Description 直接将链表数据全部压入栈中，然后循环比较
     * @Date 2020/5/5 23:28
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public boolean isPalindromeList(SingleNode<T> headNode){
        if (headNode == null) {
            return true;
        }
        Stack<SingleNode<T>> stack = new Stack<>();
        SingleNode<T> node = headNode;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = headNode;
        while (!stack.isEmpty()) {
            SingleNode<T> stackNode = stack.pop();
            if (!node.equals(stackNode)) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * @Author Moonlight
     * @Description 获取链表的中点，将中点next指向null中点右边的链表反转，左右两边开始向中间遍历对比
     * @Date 2020/5/5 23:29
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public boolean isPalindromeListLowSpace(SingleNode<T> headNode){
        if (headNode == null || headNode.next == null) {
            return true;
        }
        SingleNode<T> slow = headNode, fast = headNode, next, temp;
        // 1.找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2.中点指向null,后续节点反转
        next = slow.next;
        slow.next = null;
        while (next != null) {
            temp = next.next;
            next.next = slow;
            slow = next;
            next = temp;
        }
        // 3.此时就有两个头了，一个是headNode 一个是slow,为了不打乱原列表的结构，后续需要重新逆序
        temp = slow;
        next = headNode;

        boolean result = true;
        while (slow != null && next != null) {
            if (!slow.equals(next)) {
                result = false;
                break;
            }
            slow = slow.next;
            next = next.next;
        }

        next = temp.next;
        temp.next = null;
        while (next != null) {
            slow = next.next;
            next.next = temp;
            temp = next;
            next = slow;
        }

        return result;
    }

}
