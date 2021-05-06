package com.moonlight.algorithm.thread;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 通过N个线程顺序循环打印A、B、C...Z, 如给定 N = 3 则输出:
 *   thread0: A
 *   thread1: B
 *   thread2: C
 *   thread0: D
 *   thread1: E
 *   .....
 *
 * @author Moonlight
 * @date 2021/5/6 13:16
 */
public class NPrintLetter {

    public static void main(String[] args) throws IOException {
        Print p = new Print(4);
        for (int i = 0; i < 4; i++) {
            new Thread(p, "thread" + i).start();
            p.countDown();
        }
        System.in.read();
    }

    private static class Print implements Runnable{
        String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        CountDownLatch countDownLatch;
        final AtomicInteger index = new AtomicInteger(0);
        int threadCount;

        public Print (int n) {
            this.countDownLatch = new CountDownLatch(n);
            this.threadCount = n;
        }

        public void countDown() {
            this.countDownLatch.countDown();
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
                while (index.get() < 26) {
                    synchronized (index) {
                        if (index.get() % threadCount == Integer.parseInt(Thread.currentThread().getName().substring(6, 7))) {
                            System.out.println(Thread.currentThread().getName() + ": " + letter[index.get()]);
                            Thread.sleep(500);
                            index.incrementAndGet();
                            index.notifyAll();
                        } else {
                            index.wait();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}