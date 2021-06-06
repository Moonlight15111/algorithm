package com.moonlight.algorithm.thread;

/**
 * @ClassName MyReentrantLock
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/6 15:55
 * @Version V1.0
 **/
public class MyReentrantLock {
    private boolean isLocked = false;
    private Integer lockedCnt = 0;
    private Thread locker = null;

    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while (isLocked && !locker.equals(currentThread)) {
            wait();
        }
        isLocked = true;
        lockedCnt++;
        locker = currentThread;
    }

    public synchronized void unLocked() {
        if (Thread.currentThread().equals(locker)) {
            if (lockedCnt == 0) {
                isLocked = false;
                notifyAll();
                return;
            }
            lockedCnt--;
        }
    }
}
