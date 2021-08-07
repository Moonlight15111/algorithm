package com.moonlight.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * 假设有这么一个类：
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *   线程 A 将调用 zero()，它只输出 0 。
 *   线程 B 将调用 even()，它只输出偶数。
 *   线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 * 输入：n = 2 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 *
 * 输入：n = 5
 * 输出："0102030405"
 *
 * @ClassName PrintZeroEvenOdd
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/7 13:28
 * @Version V1.0
 **/
public class PrintZeroEvenOdd {

    public static void main(String[] args) {
        PrintZeroEvenOdd p = new PrintZeroEvenOdd(2);
        Thread A = new Thread(() -> {
            try {
                p.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                p.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                p.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        B.start();
        C.start();
        A.start();
    }

    private int n;
    private AtomicInteger p = new AtomicInteger(1);
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition(), even = lock.newCondition(), odd = lock.newCondition();

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                printNumber.accept(0);
                if ((p.get() & 1) == 0) {
                    even.signal();
                } else {
                    odd.signal();
                }
                zero.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                while ((p.get() & 1) != 0) {
                    even.await();
                }
                printNumber.accept(i);
                p.incrementAndGet();
                zero.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i += 2) {
                while ((p.get() & 1) == 0) {
                    odd.await();
                }
                printNumber.accept(i);
                p.incrementAndGet();
                zero.signal();
            }
        } finally {
            lock.unlock();
        }
    }

}
