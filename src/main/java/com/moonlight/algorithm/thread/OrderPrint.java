package com.moonlight.algorithm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程顺序打印ABC
 * @ClassName OrderPinrt
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/28 0:43
 * @Version V1.0
 **/
public class OrderPrint {

    public static void main(String[] args) {
        final int[] count = {0};
        Lock lock = new ReentrantLock();
        Condition pA = lock.newCondition();
        Condition pB = lock.newCondition();
        Condition pC = lock.newCondition();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    while (count[0] % 3 != 1) {
                        pB.await();
                    }
                    count[0]++;
                    System.out.println("B");
                    pC.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    while (count[0] % 3 != 2) {
                        pC.await();
                    }
                    count[0]++;

                    System.out.println("C");
                    pA.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    while (count[0] % 3 != 0) {
                        pA.await();
                    }
                    count[0]++;

                    System.out.println("A");
                    pB.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();


    }
}
