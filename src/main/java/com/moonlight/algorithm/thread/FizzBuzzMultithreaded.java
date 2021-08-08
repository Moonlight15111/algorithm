package com.moonlight.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 *
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *   如果这个数字可以被 3 整除，输出 "fizz"。
 *   如果这个数字可以被 5 整除，输出 "buzz"。
 *   如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 *
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *   线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 *   线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 *   线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 *   线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 *
 * @ClassName FizzBuzzMultithreaded
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/8 12:27
 * @Version V1.0
 **/
public class FizzBuzzMultithreaded {

    public static void main(String[] args) {
        FizzBuzzMultithreaded p = new FizzBuzzMultithreaded(15);
        Thread A = new Thread(() -> {
            try {
                p.fizz(() -> {
                    System.out.print("fizz, ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                p.buzz(() -> {
                    System.out.print("buzz, ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                p.fizzbuzz(() -> {
                    System.out.print("fizzbuzz, ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread D = new Thread(() -> {
            try {
                p.number(i -> System.out.print(i + ", "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        B.start();
        D.start();
        C.start();
        A.start();
    }

    private int n;
    private AtomicInteger val = new AtomicInteger(1);

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (val.get() <= n) {
            if (val.get() % 3 == 0 && val.get() % 5 != 0) {
                printFizz.run();
                val.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (val.get() <= n) {
            if (val.get() % 5 == 0 && val.get() % 3 != 0) {
                printBuzz.run();
                val.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (val.get() <= n) {
            if (val.get() % 5 == 0 && val.get() % 3 == 0) {
                printFizzBuzz.run();
                val.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (val.get() <= n) {
            if (val.get() % 5 != 0 && val.get() % 3 != 0) {
                printNumber.accept(val.get());
                val.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }

}
