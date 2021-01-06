package com.moonlight.algorithm.thread;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 两个线程交替打印0 - 100
 * @author Moonlight
 * @date 2021/1/6 11:34
 */
public class TwoThreadSwapPrintNum {

    public static volatile int i = 0;

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    while (i <= 100) {
                        lock.notify();
                        System.out.println(Thread.currentThread().getName() + " ---- " +  i++);
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    while (i <= 100) {
                        lock.notify();
                        System.out.println(Thread.currentThread().getName() + " ==== " +  i++);
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

//    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        Condition printCondition = lock.newCondition();
//        Thread t1 = new Thread(() -> {
//            lock.lock();
//            try {
//                while (i <= 100) {
//                    printCondition.signal();
//                    System.out.println(Thread.currentThread().getName() + " -- " +  i++);
//                    printCondition.await();
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        });
//        t1.start();
//        Thread t2 = new Thread(() -> {
//            lock.lock();
//            try {
//               while (i <= 100) {
//                   printCondition.signal();
//                   System.out.println(Thread.currentThread().getName() + " == " +  i++);
//                   printCondition.await();
//               }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        });
//        t2.start();
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
