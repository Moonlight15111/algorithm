package com.moonlight.algorithm.thread;

import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName MyCallable
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/26 13:11
 * @Version V1.0
 **/
public class MyCallable {

    public  static void main (String[] args) {
        CallableThreadPool pool = new CallableThreadPool();
        MyRunnable<Integer> submit = pool.submit(() -> {
            System.out.println("call - " + Thread.currentThread().getName());
//            int a = 1 / 0;
            Thread.sleep(3000);
            return 1;
        });
        System.out.println(submit.get());
    }

    static class MyRunnable<T> implements Runnable {
        private Callable<T> callable;
        private T t;
        private boolean isDone;
        private Throwable throwable;
        private final Object lock = new Object();

        public MyRunnable(Callable<T> callable) {
            this.callable = callable;
        }

        public T get() {
            synchronized (lock) {
                while (!isDone) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (throwable != null) {
                throwable.printStackTrace();
                return null;
            }
            return t;
        }

        @Override
        public void run() {
            try {
                t = callable.call();
            } catch (Throwable e) {
                throwable = e;
            } finally {
                synchronized (lock) {
                    isDone = true;
                    lock.notify();
                }
            }
        }
    }

    static class CallableThreadPool {

        private final MyLinkedList<Runnable> tasks = new MyLinkedList<>();
        private final MyLinkedList<Thread> workers = new MyLinkedList<>();

        public <T> MyRunnable<T> submit(final Callable<T> callable) {
            MyRunnable<T> tMyRunnable = new MyRunnable<>(callable);
            execute(tMyRunnable);
            return tMyRunnable;
        }

        public void execute(final Runnable task) {
            tasks.add(task);
            Thread worker = new Thread(() -> {
                for (;;) {
                    Node<Runnable> runnableNode = tasks.get();
                    System.out.println(Thread.currentThread().getName() + ": ");
                    runnableNode.getVal().run();
                }
            });
            workers.add(worker);
            worker.start();
        }

        static class MyLinkedList<T> {
            private Node<T> root = new Node<>();
            private Node<T> tail = root;

            public synchronized void add(T val) {
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

}
