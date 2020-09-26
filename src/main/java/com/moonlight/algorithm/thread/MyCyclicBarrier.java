package com.moonlight.algorithm.thread;

/**
 * @ClassName MyCyclicBarrier
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/26 13:55
 * @Version V1.0
 **/
public class MyCyclicBarrier {
    public static void main(String[] args) {
        final MyCyclicBarrier cyclicBarrier = new MyCyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            new Thread(cyclicBarrier::await).start();
        }
        while (!done) {
            System.out.println("current wait thread : " + cyclicBarrier.waitCount);
        }
        System.out.println("end....");
    }

    private static boolean done = false;
    private volatile int count = 0;
    private volatile int waitCount = 0;
    private final Object lock = new Object();

    public MyCyclicBarrier(int count) {
        this.count = count;
    }

    public void await() {
        synchronized (lock) {
            count--;
            for (;;) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 0) {
                    lock.notifyAll();
                    waitCount = 0;
                    done = true;
                    return;
                } else {
                    try {
                       waitCount++;
                       lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
