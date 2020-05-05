package com.moonlight.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LinkedDutchFlag
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/5 17:54
 * @Version V1.0
 **/
public class LinkedDutchFlag {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(9);
        list.add(12);
        list.add(1);
        LinkedDutchFlag flag = new LinkedDutchFlag();
        list = flag.sort(list);
        for (Integer node : list) {
            System.out.print(node + ", ");
        }
        System.out.println("     ");
        flag.test();
    }

    public void test(){
        SingleNode<Integer> headNode = new SingleNode<Integer>(1);
        headNode.next = new SingleNode<Integer>(4);
        headNode.next.next = new SingleNode<Integer>(2);
        headNode.next.next.next = new SingleNode<Integer>(9);
        headNode.next.next.next.next = new SingleNode<Integer>(12);
        headNode.next.next.next.next.next = new SingleNode<Integer>(1);

        headNode = dutchFlag(headNode, 2);
        SingleNode<Integer> next = headNode;
        System.out.print(headNode.data + ", ");
        while (next != null) {
            System.out.print(next.data + ", ");
            next = next.next;
        }
    }

    /**
     * @Author Moonlight
     * @Description 荷兰国旗问题。将链表分为三个区域，小于pivot的/等于pivot的/大于pivot的。
     *              遍历链表，按值分为三种情况，小于的就断开原来的next指针挂到small区里面去，等于/大于同理
     *              遍历完毕后，将三个区域首尾相连串起来
     * @Date 2020/5/5 23:11
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public SingleNode<Integer> dutchFlag(SingleNode<Integer> headNode, int pivot){
        SingleNode<Integer> smallHead = null, smallTail = null, equalHead = null, equalTail = null, largestHead = null;
        // 小于pivot的放到small下面, 等于pivot的放到equal下面, 大于pivot的放到largest下面
        while (headNode.next != null) {
            SingleNode<Integer> next = headNode.next;
            headNode.next = null;
            if (headNode.data > pivot) {
                if (largestHead == null) {
                    largestHead = headNode;
                } else {
                    SingleNode<Integer> temp = largestHead;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = headNode;
                }
            } else if (headNode.data == pivot) {
                if (equalHead == null) {
                    equalHead = headNode;
                } else {
                    SingleNode<Integer> temp = equalHead;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = headNode;
                }
                equalTail = headNode;
            } else {
                if (smallHead == null) {
                    smallHead = headNode;
                } else {
                    SingleNode<Integer> temp = smallHead;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = headNode;
                }
                smallTail = headNode;
            }
            headNode = next;
        }
        if (smallTail != null) {
            smallTail.next = equalHead;
            equalTail = equalTail == null ? smallTail : equalTail;
        }
        if (equalTail != null) {
            equalTail.next = largestHead;
        }
        return smallHead != null ? smallHead : (equalHead != null ? equalHead : largestHead);
    }

    /**
     * @Author Moonlight
     * @Description 转为数组使用快排分区的方式排序
     * @Date 2020/5/5 23:15
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public List<Integer> sort(List<Integer> list){
        Integer[] nodeArray = new Integer[list.size()];
        nodeArray = list.toArray(nodeArray);
        sort(nodeArray, 0, nodeArray.length - 1);
        return Arrays.asList(nodeArray);
    }

    public void sort(Integer[] arr, int start, int end){
        if (start == end) {
            return;
        }
        int[] res = partition(arr, start + (int)(Math.random() * ((end - start) / 2)), end);
        sort(arr, start, res[0] - 1);
        sort(arr, res[1] + 1, end);
    }

    /**
     * @Author Moonlight
     * @Description 选定最后一个位置的数作为轴，将数组分为两个区域，小于等于 和 大于。左指针从左往右遍历，右指针从右往左遍历
     *              左指针遇见大于pivot的停下，右指针遇见小于等于pivot的数停下，两者进行交换，最后将pivot与左指针进行交换
     *              返回左右指针，作为下次分区的依据
     * @Date 2020/5/5 23:16
     * @Param
     * @Exception
     * @return
     * @version
     **/
    private int[] partition(Integer[] arr, int start, int end) {
        int left = start, right = end - 1, pivot = arr[end];
        while (left <= right) {
            while (arr[left] <= pivot && left <= right) {
                left++;
            }
            while (arr[right] > pivot && left <= right) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, end);
        return new int[]{left, right};
    }

    public void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
