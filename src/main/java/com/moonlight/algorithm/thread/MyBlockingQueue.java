package com.moonlight.algorithm.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyBlockingQueue
 * @Description: 实现一个BlockingQueue
 * @Author Moonlight
 * @Date 2020/6/21 15:26
 * @Version V1.0
 **/
public class MyBlockingQueue {
    /** 可重入锁 **/
    private Lock lock = new ReentrantLock();
    /** 获取元素的condition **/
    private Condition getCondition = lock.newCondition();
    /** 放置元素的condition **/
    private Condition putCondition = lock.newCondition();
    /** 放置的总量 **/
    private int putCount;
    /** 下一个放置元素的位置 **/
    private int nextPutIndex;
    /** 下一个获取元素的位置 **/
    private int nextGetIndex;
    /** 容器 **/
    private Object[] objects;

    public MyBlockingQueue (int count) {
        this.objects = new Object[count];
        this.putCount = 0;
        this.nextGetIndex = 0;
        this.nextPutIndex = 0;
    }

    public void put (Object data) {
        this.lock.lock();
        try {
            // 如果放置总数等于容器长度，说明已经放满了，需要等待别人取数后才能继续放置
            while (this.putCount == this.objects.length) {
                this.putCondition.await();
            }
            // 放置
            this.objects[this.nextPutIndex] = data;

            this.putCount++;
            // 如果下次放置的位置已经和容器长度一致了，那么就从头开始，覆盖数据
            // 这个地方可以做一个扩展，自由选择是否覆盖
            if (++this.nextPutIndex == this.objects.length) {
                this.nextPutIndex = 0;
            }

            this.getCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }

    public Object get () {
        this.lock.lock();
        Object result = null;
        try {
            // 如果放置总数为0，说明还没有人往里面放置数据，需要等有数据后才能去获取数据
            while (this.putCount == 0) {
                this.getCondition.await();
            }
            result = this.objects[this.nextGetIndex];

            this.putCount--;

            if (++this.nextGetIndex == this.objects.length) {
               this.nextGetIndex = 0;
            }

            this.putCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue(10);
        for(int i = 0; i < 2; i++){
            new Thread(() -> {
                while(true){
                    try {
                        Thread.sleep((long)(Math.random() * 1000));
                        System.out.println(Thread.currentThread().getName() + "准备放数据!");
                        queue.put(Math.random() * 1000);
                        System.out.println(Thread.currentThread().getName() + "已经放了数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "准备取数据!");
                    System.out.println(queue.get());;
                    System.out.println(Thread.currentThread().getName() + "已经取走数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
