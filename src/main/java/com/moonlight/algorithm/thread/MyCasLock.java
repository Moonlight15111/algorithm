package com.moonlight.algorithm.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName MyCasLock
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/6 16:20
 * @Version V1.0
 **/
public class MyCasLock {
    private static final Unsafe UNSAFE;
    private static final long VAL_OFF_SET;
    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            VAL_OFF_SET = UNSAFE.objectFieldOffset(MyCasLock.class.getDeclaredField("val"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
    private volatile int val = 0;

    public void lock() {
        for (;;) {
            if (UNSAFE.compareAndSwapInt(this, VAL_OFF_SET, 0, 1)) {
                return;
            }
            Thread.yield();
        }
    }

    public void unload() {
        val = 0;
    }

}
