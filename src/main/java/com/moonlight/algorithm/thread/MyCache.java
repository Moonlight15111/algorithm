package com.moonlight.algorithm.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName MyCache
 * @Description: 实现一个简易的缓存
 * @Author Moonlight
 * @Date 2020/6/21 15:16
 * @Version V1.0
 **/
public class MyCache {
    private Map<String, Object> cache = new HashMap<>();

    public Object get(String key) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();

        Object result = null;

        try {
            result = cache.get(key);

            if (result == null) {
                // 释放读锁,因为要确保写锁的操作对于读锁是可见的,
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    if (result == null) {
                        result = "123";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.writeLock().unlock();
                }
                lock.readLock().lock();
            }
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }

}
