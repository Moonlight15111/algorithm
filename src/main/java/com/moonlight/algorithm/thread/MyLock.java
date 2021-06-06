package com.moonlight.algorithm.thread;

/**
 * @ClassName MyLock
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/6 15:51
 * @Version V1.0
 **/
public class MyLock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unLock() {
        isLocked = false;
        notifyAll();
    }
}
