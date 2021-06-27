package com.moonlight.algorithm.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 两个线程顺序打印A1 B2 C3 ... Z 26
 * @ClassName SwapPrintIII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/27 17:27
 * @Version V1.0
 **/
public class SwapPrintIII {

    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    lock.notify();
                    try {
                        System.out.print((char)(i + 65) + ",");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 27; i++) {
                    lock.notify();
                    try {
                        System.out.print(i + ",");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t2").start();
    }

}
