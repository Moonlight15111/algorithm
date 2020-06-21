package com.moonlight.algorithm.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TwoThreadCommunication
 * @Description: 实现一个容器，提供两个方法，add，size.写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * @Author Moonlight
 * @Date 2020/6/21 15:00
 * @Version V1.0
 **/
public class TwoThreadCommunication {

    private List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public void countDownLatch () {
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            try {
                if (this.size() != 5) {
                    latch.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end ...");
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                this.add(new Object());
                if (i == 5) {
                    latch.countDown();
                }
                System.out.println("add " + i);
            }
        }, "t1").start();
    }

    public void notifyAndWait () {
        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    if (this.size() != 5) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 end ...");
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    this.add(new Object());
                    if (i == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("add " + i);
                }
            }
        }, "t1").start();
    }

    public static void main(String[] args) {
        TwoThreadCommunication test = new TwoThreadCommunication();
        test.countDownLatch();
        test.notifyAndWait();
    }

}
