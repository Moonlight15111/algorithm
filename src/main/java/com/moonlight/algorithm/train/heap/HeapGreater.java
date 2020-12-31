package com.moonlight.algorithm.train.heap;

import java.util.*;
/**
 * 增强堆
 * @ClassName HeapGreater
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/29 21:44
 * @Version V1.0
 **/
public class HeapGreater<T> {

    private List<T> heap;
    private Map<T, Integer> indexRecord;
    private int heapSize;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<? super T> comparator) {
        heap = new ArrayList<>();
        indexRecord = new HashMap<>();
        heapSize = 0;
        comp = comparator;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexRecord.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexRecord.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T res = heap.get(0);
        swap(0, heapSize - 1);
        indexRecord.remove(res);
        heap.remove(--heapSize);
        heapify(0);
        return res;
    }

    public void remove(T obj) {
        T replace = heap.get(heapSize - 1);
        int index = indexRecord.get(obj);
        indexRecord.remove(obj);
        heap.remove(--heapSize);
        if (obj != replace) {
            heap.set(index, replace);
            indexRecord.put(replace, index);
            resign(replace);
        }
    }

    public void resign(T obj) {
        heapInsert(indexRecord.get(obj));
        heapify(indexRecord.get(obj));
    }

    private void heapInsert(int index) {
        while (comp.compare(heap.get(index), heap.get((index - 1) >> 1)) < 0) {
            swap(index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private void heapify(int index) {
        int left = 2 * index + 1, largest;
        while (left < heapSize) {
            largest = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? left : index;
            largest = comp.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
            if (largest == index) {
                break;
            }
            swap(largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexRecord.put(o2, i);
        indexRecord.put(o1, j);
    }
}
