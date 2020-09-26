package com.moonlight.algorithm.thread;

/**
 * @ClassName MySemaphore
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/9/26 14:12
 * @Version V1.0
 **/
public class MySemaphore {

    public static void main(String[] args) {
        final MySemaphore semaphore = new MySemaphore(1);
        Thread t1 = new Thread(() -> {
            System.out.println(" 1. t1 try acquire"); // 1
            semaphore.acquire();
            System.out.println(" 2. t1 acquire success"); // 2
            try {
                Thread.sleep(10000);
                semaphore.release();
                System.out.println(" 3. t1 release success"); // 3
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread = new Thread(() -> {
            System.out.println(" 4. t2 try acquire"); // 4
            semaphore.acquire();
            System.out.println(" 5. t2 acquire success"); // 5
            semaphore.release();
            System.out.println(" 6. t2 release success"); // 6
        });
        t1.start();
        thread.start();
    }

    private volatile int count = 0;
    private volatile int num = 0;
    private final Object lock = new Object();

    public MySemaphore(int num) {
        this.num = num;
    }

    public void acquire() {
        synchronized (lock) {
            for (;;) {
                if (count == num) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    count++;
                    return;
                }
            }
        }
    }

    public void release() {
        synchronized (lock) {
            count--;
            lock.notify();
        }
    }



}
