package com.moonlight.algorithm.thread;

/**
 * @ClassName MyCountDownLatch
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/26 13:33
 * @Version V1.0
 **/
public class MyCountDownLatch {

    public static void main(String[] args) {
        final MyCountDownLatch countDownLatch = new MyCountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(countDownLatch::countDown).start();
        }
        System.out.println("start....");
        countDownLatch.await();
        System.out.println("end....");
    }

    private volatile int count = 0;
    private final Object lock = new Object();

    public MyCountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void countDown() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count -1 = " + count);
        if (count == 0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                lock.notify();
            }
        }
    }

    public void await() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
