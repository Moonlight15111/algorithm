package com.moonlight.algorithm.thread;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @ClassName ScheduledThreadPoolExecutorSourceCode
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/27 21:18
 * @Version V1.0
 **/
public class ScheduledThreadPoolExecutorSourceCode {

    public static void main(String[] args) {
//        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
//        executor.scheduleAtFixedRate(() -> System.out.println("abc " + new Date()), 8, 20, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(() -> System.out.println("123 " + new Date()), 10, 30, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(() -> System.out.println(" efg " + new Date()), 8, 12, TimeUnit.SECONDS);
//        executor.scheduleWithFixedDelay(() -> System.out.println(" 789 " + new Date()), 10, 5, TimeUnit.SECONDS);

        // 只用调度线程池的调度特性，把延时任务扔到其他线程池去执行，不阻塞当前调度线程池
        // 分布式任务调度 XXL-JOB源码好像就是这么玩的
        // ThreadPoolExecutor，可以控制线程数、任务队列、拒绝策略，但是ScheduledThreadPoolExecutor就没这么爽了顶多控制个核心线程数
        // 用ScheduledThreadPoolExecutor去数据库周期性的查任务，查到了以后扔到ThreadPoolExecutor线程池延迟执行
        ExecutorService pool = Executors.newCachedThreadPool();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> pool.execute(() -> {
            System.out.println(new Date() + " 1");
        }), 1, TimeUnit.SECONDS);
        executor.schedule(() -> pool.execute(() -> {
            System.out.println(new Date() + " 2");
        }), 1, TimeUnit.SECONDS);
        executor.schedule(() -> pool.execute(() -> {
            System.out.println(new Date() + " 3");
        }), 1, TimeUnit.SECONDS);
        executor.schedule(() -> pool.execute(() -> {
            System.out.println(new Date() + " 4");
        }), 1, TimeUnit.SECONDS);
        executor.schedule(() -> pool.execute(() -> {
            System.out.println(new Date() + " 5");
        }), 1, TimeUnit.SECONDS);
    }

//    private class ScheduledFutureTask<V>
//            extends FutureTask<V> implements RunnableScheduledFuture<V> {
//
//         任务序列号，依赖放入队列的顺序进行严格递增
//       /** Sequence number to break ties FIFO */
//        private final long sequenceNumber;
//         这个任务执行的时间点，在哪个时间点执行
//         这个时间的计算方式 = time(在任务执行完的时间点或者任务开始执行时，这取决于这个任务是WithFixedDelay还是AtFixedRate() + 执行周期
// /** The time the task is enabled to execute in nanoTime units */
//        private long time;
//
//        /**
//         * Period in nanoseconds for repeating tasks.  A positive
//         * value indicates fixed-rate execution.  A negative value
//         * indicates fixed-delay execution.  A value of 0 indicates a
//         * non-repeating task.
//         */
//         执行周期  == 0 表示不是一个周期性任务，跑完就不执行了
//         > 0 表示固定周期执行(即AtFixedRate,不管上一个任务执行没执行完,从上一个任务开始的时间开始算下一个任务执行的时间)
//         < 0 表示固定延迟执行(即WithFixedDelay,从上一个任务执行完的时间点开始算下一个任务执行的时间)
//        private final long period;
//
//    public void run() {
//        boolean periodic = isPeriodic();
//        当前状态允不允许跑任务
//        if (!canRunInCurrentRunState(periodic))
//            cancel(false);
//        如果不是周期性的任务，就直接执行
//        else if (!periodic)
//            ScheduledThreadPoolExecutor.ScheduledFutureTask.super.run();
//       runAndReset() 执行任务，执行完毕后将任务的属性清空、还原，因为这是一个周期性的任务
//        else if (ScheduledThreadPoolExecutor.ScheduledFutureTask.super.runAndReset()) {
//            设置下次执行时间
//            setNextRunTime();
//            再次将任务放入任务队列进行执行
//            reExecutePeriodic(outerTask);
//        }
//    }

//    所有的schedule()方法最后都会走到这个方法，这个方法只是单纯的判断线程池的状态，然后往里面放任务
//    因为这是定时调度，不应该线程一启动就执行任务，这不好不符合语义
//    所以关键在于获取任务，但是获取任务执行，都是ThreadPoolExecutor方法，不存在延时这种说法，所以最终是落在DelayedWorkQueue里面怎么取任务的
//    private void delayedExecute(RunnableScheduledFuture<?> task) {
//        if (isShutdown())
//            reject(task);
//        else {
//            super.getQueue().add(task);
//            if (isShutdown() &&
//                    !canRunInCurrentRunState(task.isPeriodic()) &&
//                    remove(task))
//                task.cancel(false);
//            else
//                确保至少有一个线程来处理任务
//                ensurePrestart();
//        }
//    }
//
//    schedule是一个任务调度，需要延迟执行的，所以任务需要能够排队执行，且放进去的任务，不一定能够立即执行，需要等待时间满足了才执行
//    所以它应该要按执行时间进行排序，先执行的排前面
//    ThreadPoolExecutor原有的部分逻辑不满足需求，所以需要改造，
//
//    DelayedWorkQueue本质上是一个小根堆，毕竟是调度执行，肯定是最先执行的放最前面，同时根据局部性原理、缓存行所以使用了数组，因为数组是连续存储的
//    优先级队列(数组小根堆)  有一个线程池,复用的ThreadPoolExecutor  ScheduledFutureTask封装了周期性调度任务，执行周期、下次执行时间
//    public RunnableScheduledFuture<?> take() throws InterruptedException {
//        final ReentrantLock lock = this.lock;
//        lock.lock和lock.lockInterruptibly()区别在于lockInterruptibly是可响应中断的
//        lock.lockInterruptibly();
//        try {
//            for (;;) {
//                RunnableScheduledFuture<?> first = queue[0];
//                说明没任务
//                if (first == null)
//                    available.await();
//                else {
//                    这个任务还要等多久才能执行
//                    long delay = first.getDelay(NANOSECONDS);
//                    肯定已经到执行时间点或者已经超过了执行时间点了
//                    if (delay <= 0)
//                        return finishPoll(first);
//                    如果没到执行时间且leader不为空，就让后进来的线程等着，leader就是第一个拿到任务的线程
//                    而leader只要等delay纳秒就好，为什么要这么写呢？
//                    如果有十个线程进来，没必要让十个线程都等着，因为其他线程都没有获取到这个任务
//                    而且我本身只要唤醒拿到任务的这一个线程就好了为什么要去唤醒十个呢
//                    first = null; // don't retain ref while waiting
//                    if (leader != null)
//                        available.await();
//                    else {
//                        Thread thisThread = Thread.currentThread();
//                        leader = thisThread;
//                        try {
//                            available.awaitNanos(delay);
//                        } finally {
//                            leader等完了以后置空，然后获取任务，退出循环，finally中在还有任务的情况下唤醒一个线程，执行任务
//                            if (leader == thisThread)
//                                leader = null;
//                        }
//                    }
//                }
//            }
//        } finally {
//            if (leader == null && queue[0] != null)
//                available.signal();
//            lock.unlock();
//        }
//    }


//    }


}
