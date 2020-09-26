package com.moonlight.algorithm.pool;

import lombok.Data;
import lombok.Getter;

/**
 * @ClassName ThreadPool
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/26 12:27
 * @Version V1.0
 **/
public class ThreadPool {

    public static void main (String[] args) {
        ThreadPool pool = new ThreadPool();
        Runnable r1 = () -> System.out.println(111111);
        Runnable r2 = () -> System.out.println(222222);
        Runnable r3 = () -> System.out.println(333333);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
    }

    private final MyLinkedList<Runnable> tasks = new MyLinkedList<>();
    private final MyLinkedList<Thread> workers = new MyLinkedList<>();

    public void execute(final Runnable task) {
        tasks.insert(task);
        Thread worker = new Thread(() -> {
            for (;;) {
                Node<Runnable> runnableNode = tasks.get();
                System.out.println(Thread.currentThread().getName() + ": ");
                runnableNode.getVal().run();
            }
        });
        workers.insert(worker);
        worker.start();
    }

    static class MyLinkedList<T> {
        private Node<T> root = new Node<>();
        private Node<T> tail = root;

        public synchronized void insert(T val) {
            Node<T> node = new Node<>();
            node.setVal(val);

            tail.next = node;
            tail = node;

            this.notify();
        }

        public synchronized Node<T> get() {
            Node<T> next = root.getNext();
            if (next != null) {
                root.next = next.next;
                if (next == tail) {
                    tail = root;
                }
                return next;
            } else {
                try {
                    this.wait();
                    return get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    @Data
    static class Node<T> {
        private T val;
        private Node<T> next;
    }
}
