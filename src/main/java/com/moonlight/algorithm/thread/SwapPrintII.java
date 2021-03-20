package com.moonlight.algorithm.thread;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 建三个线程, 依次打印A1Z,B2Y,C3X,....,Z26A
 * @author Moonlight
 * @date 2021/3/20 12:17
 */
public class SwapPrintII {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            data.printAsc();
        },"t1").start();

        new Thread(()->{
            data.printNum();
        },"t2").start();

        new Thread(()->{
            data.printDesc();
        },"t3").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Data {
        private Lock lock = new ReentrantLock();
        private volatile int num = 1;
        private Condition numCondition = lock.newCondition();
        private Condition letterAscCondition = lock.newCondition();
        private Condition letterDescCondition = lock.newCondition();

        public void printAsc() {
            try {
                lock.lock();

                for (int i = 0; i < 26; i++) {
                    while (num != 1) {
                        letterAscCondition.await();
                    }
                    System.out.print((char)(i + 65) + ",");
                    num = 2;
                    numCondition.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printNum() {
            try {
                lock.lock();

                for (int i = 1; i <= 26; i++) {
                    while (num != 2) {
                        numCondition.await();
                    }
                    System.out.print(i + ",");
                    num = 3;
                    letterDescCondition.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printDesc() {
            try {
                lock.lock();

                for (int i = 25; i >= 0; i--) {
                    while (num != 3) {
                        letterDescCondition.await();
                    }
                    System.out.print((char)(i + 65) + ",");
                    num = 1;
                    letterAscCondition.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}
