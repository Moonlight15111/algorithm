package com.moonlight.algorithm.heap;

import com.moonlight.algorithm.Const;

/**
 * @ClassName MyHeap
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/4 20:25
 * @Version V1.0
 **/
public class MyMaxHeap {

    public static void main(String[] args){
        MyMaxHeap maxHeap = new MyMaxHeap(9);
        for (int val : Const.arr) {
            maxHeap.push(val);
        }
        Const.print(maxHeap.heap);

        System.out.println(maxHeap.popMax());
        Const.print(maxHeap.heap);
    }

    private int heapPos;
    private int[] heap;

    public MyMaxHeap(int length){
        this.heap = new int[length];
        this.heapPos = 0;
    }

    public void push(int num){
        if (this.heapPos >= this.heap.length) {
            throw new RuntimeException("heap is full");
        }
        this.heap[heapPos] = num;
        insert2Heap();
        this.heapPos++;
    }

    private void insert2Heap() {
        int temp = this.heapPos;
        while (this.heap[temp] > this.heap[(temp - 1) / 2]) {
            Const.swap(this.heap, temp, (temp - 1) / 2);
            temp = (temp - 1) / 2;
        }
    }

    // 获取最大的值后继续保持大根堆结构
    public int popMax(){
        int max = this.heap[0];
        // 直接钦定最后一个数为头，但此时不能保证大根堆结构，需要进行heapify操作
        Const.swap(this.heap, 0, --this.heapPos);
        heapify(0);

        return max;
    }

    // heapify操作,从index节点往下找，不断和自己的孩子节点进行对比，直到孩子节点都不在比自身小，或者没有孩子节点了
    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < this.heapPos) {
            int largest = left + 1 < this.heapPos && this.heap[left] < this.heap[left + 1] ? left + 1 : left;
            largest = this.heap[largest] > this.heap[index] ? largest : index;
            if (largest == index) {
                break;
            }
            Const.swap(this.heap, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

}
