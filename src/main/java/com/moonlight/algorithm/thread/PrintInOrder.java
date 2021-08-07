package com.moonlight.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * 我们提供了一个类：
 *   public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 *  }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *   一个将会调用 first() 方法
 *   一个将会调用 second() 方法
 *   还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * @ClassName printInOrder
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/7 12:48
 * @Version V1.0
 **/
public class PrintInOrder {

    public static void main(String[] args) {
        PrintInOrder p = new PrintInOrder();
        Thread A = new Thread(() -> {
            try {
                p.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                p.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                p.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        C.start();
        B.start();
        A.start();
    }

    private AtomicInteger val = new AtomicInteger(1);

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (val.get() != 1) {
            wait();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        val.incrementAndGet();
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (val.get() != 2) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        val.incrementAndGet();
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (val.get() != 3) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        val.set(1);
        notifyAll();
    }

}
