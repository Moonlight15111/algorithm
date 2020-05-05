package com.moonlight.algorithm.heap;

import com.moonlight.algorithm.Const;

/**
 * @ClassName MyMinHeap
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/4 22:48
 * @Version V1.0
 **/
public class MyMinHeap {

    public static void main(String[] args){
        MyMinHeap minHeap = new MyMinHeap(9);
        for (int val : Const.arr) {
            minHeap.push(val);
        }
        Const.print(minHeap.heap);

        System.out.println(minHeap.popMin());
        Const.print(minHeap.heap);
    }

    private int popMin() {
        int res = this.heap[0];

        Const.swap(this.heap, 0, --this.heapPos);
        heapify(0);

        return res;
    }

    private int heapPos;
    private int[] heap;

    public MyMinHeap(int length){
        this.heap = new int[length];
        this.heapPos = 0;
    }

    public void push(int num){
        this.heap[this.heapPos] = num;
        push();
        this.heapPos++;
    }

    private void push() {
        int temp = this.heapPos;
        while (this.heap[temp] < this.heap[(temp - 1) / 2]){
            Const.swap(this.heap, temp, (temp - 1) / 2);
            temp = (temp - 1) / 2;
        }
    }

    public void heapify(int index){
        int left = 2 * index + 1, length = this.heap.length;
        while (left < length) {
            int minimum = left + 1 < length && this.heap[left] > this.heap[left + 1] ? left + 1 : left;
            minimum = this.heap[index] < this.heap[minimum] ? index : minimum;
            if (index == minimum) {
                break;
            }
            Const.swap(this.heap, index, minimum);
            index = minimum;
            left = 2 * index + 1;
        }
    }

}
