package com.moonlight.algorithm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SwapPrint
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/25 21:19
 * @Version V1.0
 **/
public class SwapPrint {
    private static String[] letterArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition letterCondition = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    for (int i = 0, length = letterArray.length; i < length; i++) {
                        System.out.println(letterArray[i]);
                        letterCondition.signal();
                        letterCondition.await();
                    }
                    letterCondition.signal();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }, "Thread - 1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    for (int i = 0, length = letterArray.length; i < length; i++) {
                        System.out.println(letterArray[i]);
                        letterCondition.signal();
                        letterCondition.await();
                    }
                    letterCondition.signal();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }, "Thread - 2").start();
//        SwapPrint s = new SwapPrint();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (s.flag){
//                    s.lockConditionPrintLetter();
//                }
//            }
//        }, "Thread - 1").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!s.flag){
//                    s.lockConditionPrintNum();
//                }
//            }
//        }, "Thread - 2").start();
//        s.notifyAndWaitPrint();
    }

    private Lock lock = new ReentrantLock();
    private Condition letterCondition = lock.newCondition(), numberCondition = lock.newCondition();
    private boolean flag = true;
    public void lockConditionPrintLetter(){
        for (int i = 0, length = letterArray.length; i < length; i++) {
            lock.lock();
            try {
                if (!flag) {
                    letterCondition.await();
                }
                System.out.print(letterArray[i]);
                numberCondition.signal();
                flag = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void lockConditionPrintNum(){
        for (int i = 0, length = letterArray.length; i < length; i++) {
            lock.lock();
            try {
                if (flag) {
                    numberCondition.await();
                }
                System.out.print(i+1);
                letterCondition.signal();
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void notifyAndWaitPrint(){
        final Object object = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, length = letterArray.length; i < length; i++) {
                    synchronized (object) {
                        try {
                            object.notify();  // 1.
                            System.out.print(letterArray[i]);   // 2.
                            object.wait(); // 3.
                            object.notify(); // 7.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "thread - 1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, length = letterArray.length; i < length; i++) {
                    synchronized (object) {
                        try {
                            object.notify(); // 4.
                            System.out.print(i+1); // 5.
                            object.wait(); // 6.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "thread - 2").start();
    }
}
