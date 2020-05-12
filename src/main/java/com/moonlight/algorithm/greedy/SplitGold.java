package com.moonlight.algorithm.greedy;


import java.util.PriorityQueue;

/**
 * @ClassName SplitGold
 * @Description: 一根金条分成两半，需要花费和金条长度一样的钱。如：金条长度为60，分成10/20/30三个部分
 *               如果先将金条分成10/50两个部分，需要花费60块钱，再将50长度部分分为20/30两个部分，需要花费50块钱，则共需要花费110
 *               如果先分成30/30两个部分，需要花费60，再将某条30长度的分为10/20两个部分，需要花费30，则共需要花费90.
 *               求最小分割代价。
 *               思路：哈夫曼树(一组数据中找出权值最小的两个A, B，求和得C，然后，把C融入数据改组数据，同时删去A , B)
 * @Author Moonlight
 * @Date 2020/5/12 21:42
 * @Version V1.0
 **/
public class SplitGold {

    public static void main (String[] args) {
        int[] copies = {3, 7, 6, 9, 1, 4};

        System.out.println(splitMinCosts(copies));

    }

    public static int splitMinCosts(int[] copies){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int val : copies) {
            priorityQueue.add(val);
        }

        int sum = 0, cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }

        return sum;
    }


    public static void sortBigHeap(int[] copies){
        buildBigHeap(copies);
        int heapLength = copies.length;
        while (heapLength > 0) {
            swap(copies, 0, heapLength - 1);
            heapLength--;
            heapify(copies, 0, heapLength);
        }
    }

    public static void buildBigHeap(int[] copies){
        for (int i = 0, length = copies.length; i < length; i++) {
            int index = i, parentIndex = (index - 1) / 2;
            while (copies[index] > copies[parentIndex]) {
                swap(copies, index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }
    }

    private static void heapify(int[] copies, int index, int heapLength) {
        int left = 2 * index + 1;
        while (left < heapLength) {
            int largest = left + 1 < heapLength && copies[left + 1] > copies[left] ? left + 1 : left;

            largest = copies[index] >= copies[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(copies, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] copies, int index, int parentIndex){
        int temp = copies[index];
        copies[index] = copies[parentIndex];
        copies[parentIndex] = temp;
    }

}
