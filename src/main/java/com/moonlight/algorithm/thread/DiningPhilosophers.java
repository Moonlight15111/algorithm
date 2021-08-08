package com.moonlight.algorithm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/the-dining-philosophers/
 *
 * 5 个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5 个哲学家，5 根叉子）
 * 所有的哲学家都只会在思考和进餐两种行为间交替。哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。
 * 每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。
 * 假设面的数量没有限制，哲学家也能随便吃，不需要考虑吃不吃得下。
 * 设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。
 *
 * 哲学家从 0 到 4 按 顺时针 编号。请实现函数 void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)：
 *   philosopher 哲学家的编号。
 *   pickLeftFork 和 pickRightFork 表示拿起左边或右边的叉子。
 *   eat 表示吃面。
 *   putLeftFork 和 putRightFork 表示放下左边或右边的叉子。
 *   由于哲学家不是在吃面就是在想着啥时候吃面，所以思考这个方法没有对应的回调。
 * 给你 5 个线程，每个都代表一个哲学家，请你使用类的同一个对象来模拟这个过程。在最后一次调用结束之前，可能会为同一个哲学家多次调用该函数。
 *
 * @ClassName DiningPhilosophers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/8 13:26
 * @Version V1.0
 **/
public class DiningPhilosophers {

    public static void main(String[] args) {
        Thread pl = new Thread(() -> {
            System.out.println("pick left");
        });
        Thread pr = new Thread(() -> {
            System.out.println("pick right");
        });
        Thread eat = new Thread(() -> {
            System.out.println(" eat ");
        });
        Thread putl = new Thread(() -> {
            System.out.println(" put left ");
        });
        Thread putr = new Thread(() -> {
            System.out.println(" put right ");
        });

        DiningPhilosophers dp = new DiningPhilosophers();

        Thread[] ph = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int n = i;
            ph[i] = new Thread(() -> {
                try {
                    dp.wantsToEat(n, pl, pr, eat, putl, putr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (Thread t : ph) {
            t.start();
        }
    }

    public DiningPhilosophers() {}

    // 5把叉子
    private Lock[] forks = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat, Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        int forkR = (philosopher + 1) % 5;

        forks[philosopher].lock();
        forks[forkR].lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[philosopher].unlock();
        forks[forkR].unlock();
    }

}
