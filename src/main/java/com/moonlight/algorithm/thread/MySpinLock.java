package com.moonlight.algorithm.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName MySpinLock
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/6 16:08
 * @Version V1.0
 **/
public class MySpinLock {
    private AtomicReference<Thread> reference = new AtomicReference<>();
    public void lock1 () {
        Thread currentThread = Thread.currentThread();
        for (;;){
            if (reference.compareAndSet(null, currentThread)) {
                break;
            }
        }
    }
    public void unLock2 () {
        Thread currentThread = Thread.currentThread();
        reference.compareAndSet(currentThread, null);
    }

    private boolean isLock = false;
    public void lock () {
        for (;;){
            if (!isLock) {
                break;
            }
        }
        isLock = true;
    }
    public void unLock () {
        isLock = false;
    }
}
