package com.moonlight.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * 我们提供一个类：
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * @ClassName PrintFoobarAlternately
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/7 13:12
 * @Version V1.0
 **/
public class PrintFoobarAlternately {

    public static void main(String[] args) throws InterruptedException {
        PrintFoobarAlternately p = new PrintFoobarAlternately(2);
        Thread A = new Thread(() -> {
            try {
                p.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                p.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        B.start();
        Thread.sleep(1000);
        A.start();
    }

    private int n;
    private AtomicInteger val = new AtomicInteger(1);
//    private Lock lock = new ReentrantLock();
//    private Condition foo = lock.newCondition(), bar = lock.newCondition();

    public PrintFoobarAlternately(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
//        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while ((val.get() & 1) != 1) {
//                    foo.await();
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                val.incrementAndGet();
//                bar.signal();
                notifyAll();
            }
        } finally {
//            lock.unlock();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
//        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while ((val.get() & 1) == 1) {
//                    bar.await();
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                val.incrementAndGet();
//                foo.signal();
                notifyAll();
            }
        } finally {
//            lock.unlock();
        }
    }

}