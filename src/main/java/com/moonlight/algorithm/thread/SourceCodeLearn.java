package com.moonlight.algorithm.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SourceCodeLearn
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/25 20:52
 * @Version V1.0
 **/
public class SourceCodeLearn {

    public void threadKeepAliveAndGetTask() {
        /*
ctl: 高三位表示线程池运行状态: Running、SHUTDOWN、STOP、TIDYING、TERMINATED  低29位存工作的线程数

一般一个线程执行完任务之后就结束了，Thread.start()只能调用一次，一旦这个调用结束，则该线程就到了stop状态，不能再次调用start。
如果你对一个已经启动的线程对象再调用一次start方法的话,会产生:IllegalThreadStateException异常，但是Thread的run方法是可以重复调用的。

           private Runnable getTask() {
            // Are workers subject to culling?
            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;

            if ((wc > maximumPoolSize || (timed && timedOut))
                && (wc > 1 || workQueue.isEmpty())) {
                if (compareAndDecrementWorkerCount(c))
                    return null;
                continue;
            }

            try {
                Runnable r = timed ?
                    workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                    workQueue.take();
                if (r != null)
                    return r;
                timedOut = true;
            } catch (InterruptedException retry) {
                timedOut = false;
            }
           }

 private void processWorkerExit(Worker w, boolean completedAbruptly) {
   if (completedAbruptly) // If abrupt, then workerCount wasn't adjusted
            decrementWorkerCount();

        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            completedTaskCount += w.completedTasks;
            workers.remove(w);
        } finally {
            mainLock.unlock();
        }

        tryTerminate();

        int c = ctl.get();
        if (runStateLessThan(c, STOP)) {
            if (!completedAbruptly) {
                int min = allowCoreThreadTimeOut ? 0 : corePoolSize; // 线程池最小数量，在于能否释放核心线程
                if (min == 0 && ! workQueue.isEmpty())  // 如果任务队列还有任务，就还要有一个线程来处理任务
                    min = 1;  在任务队列还有任务的时候，最起码保证要有一个线程来执行完这些任务
                if (workerCountOf(c) >= min)
                    return; // replacement not needed
            }
            addWorker(null, false); // 可能没有线程来执行阻塞队列里的任务 因此尝试创建线程去执行任务
        }
 }

非核心线程延迟死亡，如何实现 ?
  通过任务队列workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS)，让线程阻塞等待一段时间，如果没有取到任务，则线程死亡

核心线程为什么不死 ?
  通过任务队列workQueue.take()阻塞，让线程一直等待，直到获取到任务

如何释放核心线程 ?
  将allowCoreThreadTimeOut设置为true

由以上源码可知线程池其实并不区分核心线程与非核心线程，只是根据当前线程池容量状态做不同的处理来进行调整，
0 - corePoolSize 表示线程池里只有核心线程，corePoolSize - maximumPoolSize 表示线程池里核心线程已满，存在非核心线程
所以corePoolSize只是线程池希望并保持的并发状态  corePoolSize - maximumPoolSize只是线程池允许的并发的超载状态，不希望长期保持。

 */
    }

    public void execute() {
        //    public void execute(Runnable command) {
//        if (command == null)
//            throw new NullPointerException();
//        /*
//         * Proceed in 3 steps:
//         *
//         * 1. If fewer than corePoolSize threads are running, try to
//         * start a new thread with the given command as its first
//         * task.  The call to addWorker atomically checks runState and
//         * workerCount, and so prevents false alarms that would add
//         * threads when it shouldn't, by returning false.
//         *
//         * 2. If a task can be successfully queued, then we still need
//         * to double-check whether we should have added a thread
//         * (because existing ones died since last checking) or that
//         * the pool shut down since entry into this method. So we
//         * recheck state and if necessary roll back the enqueuing if
//         * stopped, or start a new thread if there are none.
//         *
//         * 3. If we cannot queue task, then we try to add a new
//         * thread.  If it fails, we know we are shut down or saturated
//         * and so reject the task.
//         */
//        int c = ctl.get();
//        if (workerCountOf(c) < corePoolSize) { // 1.如果当前工作线程数小于核心线程数, 就起一个核心线程去执行这个任务
//            if (addWorker(command, true))
//                return;
//            c = ctl.get();
//        }
//        if (isRunning(c) && workQueue.offer(command)) { // 2.如果核心线程已经达到上限且线程池还在运行状态，就尝试把任务丢到任务队列里面去，
//            int recheck = ctl.get();                    // 2.1. 丢到任务队列里面以后，还要再次检查一下线程池的状态，因为可能在我们把任务丢到任务队队列
//            if (! isRunning(recheck) && remove(command))// 的过程中，线程池被关闭了，这时就需要把任务从任务队列移出去，并调用拒绝策略
//                reject(command);                        // 2.2. 还有一种可能是，在我们把任务丢到任务队队列的过程中，线程池中的线程全都被释放了
//            else if (workerCountOf(recheck) == 0)       // 此时就需要往里面重新加工作线程
//                addWorker(null, false);                 // 如果主动开启allowCoreThreadTimeOut或者当前工作线程大于corePoolSize，那么线程是可以被超时回收的
//        }                                               // allowCoreThreadTimeOut默认为false的，即默认不允许核心线程超时回收
//        else if (!addWorker(command, false))            // 3. 如果核心线程、任务队列都满了，就尝试进入超载状态，起一个非核心线程去处理任务
//            reject(command);                            // 4. 都不行就执行拒绝策略
//    }                                                   // 所以有两种情况会执行拒绝策略
//                                                        //    1.线程池处于非运行状态  2. 核心线程、任务队列、非核心线程都满了
    }

    public void addWorker() {
        //private boolean addWorker(Runnable firstTask, boolean core) {
//    retry:  这一整个循环，其实就是判断线程池状态、任务队列状态，然后对线程池数量 + 1
//    for (;;) {
//        int c = ctl.get();
//        int rs = runStateOf(c);
//
//        1. 当线程处于非运行态时，线程池是拒绝执行任务的 因此不需要任务，也不添加线程
//        2. 当线程处于SHUTDOWN状态时，线程池需要把任务处理完，才会到达后面的TIDYING、TERMINATED状态。因此，如果阻塞队列还有任务的话，继续添加线程来加快处理。
//        // Check if queue empty only if necessary.
//        if (rs >= SHUTDOWN &&
//                ! (rs == SHUTDOWN &&
//                        firstTask == null &&
//                        ! workQueue.isEmpty()))
//            return false;
//
//        for (;;) {
//            int wc = workerCountOf(c);
//            1.如果：
//               1.线程数超过或等于能表示的线程数的上限
//               或者
//               2.核心线程数达到上限 或者 最大线程数达到上限 这取决于要添加的这个worker是不是一个核心线程
//            直接返回false
//            if (wc >= CAPACITY ||
//                    wc >= (core ? corePoolSize : maximumPoolSize))
//                return false;
//
//            2. CAS操作增加线程数，然后跳出循环
//               道格李的套路一般都是先改好状态，然后尝试去做事，做成功了也就算了，失败了就搞个状态回退
//            if (compareAndIncrementWorkerCount(c))
//                break retry;
//
//            3. 如果上面的cas操作不成功，那么说明有线程竞争，所以需要重新取一下ctl，判断一下线程池的状态
//               因为这个过程中有其他线程直接关闭了线程也不一定，所以需要再判断一下线程池的状态，如果状态和开始不一致
//               就直接重新开始整个retry代码块
//            c = ctl.get();  // Re-read ctl
//            if (runStateOf(c) != rs)
//                continue retry;
//            // else CAS failed due to workerCount change; retry inner loop
//        }
//    }
//
//    正式创建工作线程
//    boolean workerStarted = false;  工作线程是否启动
//    boolean workerAdded = false;  工作线程是否添加成功
//    ThreadPoolExecutor.Worker w = null;
//    try {
//        w = new ThreadPoolExecutor.Worker(firstTask);
//        final Thread t = w.thread;
//        if (t != null) {
//            final ReentrantLock mainLock = this.mainLock;
//            mainLock.lock();
//            try {
//                // Recheck while holding lock.
//                // Back out on ThreadFactory failure or if
//                // shut down before lock acquired.
//                int rs = runStateOf(ctl.get());
//
//                if (rs < SHUTDOWN ||
//                        (rs == SHUTDOWN && firstTask == null)) {
//                    if (t.isAlive()) // precheck that t is startable
//                        throw new IllegalThreadStateException();
//                    workers.add(w);
//                    int s = workers.size();
//                    if (s > largestPoolSize)
//                        largestPoolSize = s;
//                    workerAdded = true;
//                }
//            } finally {
//                mainLock.unlock();
//            }
//            if (workerAdded) {
//                t.start();
//                workerStarted = true;
//            }
//        }
//    } finally {
//        if (! workerStarted)
//            线程启动失败，线程池数量状态改回去，也就是线程数量 - 1，然后从线程容器中移除worker线程
//            addWorkerFailed(w);
//    }
//    return workerStarted;
//}

    }

    public void runWorkerAndProcessWorkerExit() {
        /*
         怎么获取线程池里面的异常

          重写afterExecute方法
          task.run里面try catch
          future去get
          线程设置uncaughtExceptionHandler

          当线程池的线程因为遭遇到用户线程异常（开发者自己出bug抛异常了）
          那么它会重新再起一个新的线程
         */
//        final void runWorker(ThreadPoolExecutor.Worker w) {
//            Thread wt = Thread.currentThread();
//            Runnable task = w.firstTask;
//            w.firstTask = null;
//            w.unlock(); // 改变标志位，表示可以被中断，其实就是 state 变成 0
//            boolean completedAbruptly = true;
//            try {
//                task一开始是firstTask，也就是最开始分配给它的任务，后面就通过getTask()从任务队列里拿任务
//                while ( task != null ||
//                        阻塞获取任务
//                        (task = getTask()) != null
//                      ) {
//                    w.lock();
//                    // If pool is stopping, ensure thread is interrupted;
//                    // if not, ensure thread is not interrupted.  This
//                    // requires a recheck in second case to deal with
//                    // shutdownNow race while clearing interrupt
//                    如果：
//                       线程池已经进入STOP、TIDYING、TERMINATED状态了
//                       或者 当前线程已经被中断了且线程池已经进入STOP、TIDYING、TERMINATED状态了
//                      但是当前工作线程并没有被中断，则手动将当前工作线程中断
//                    if ( (runStateAtLeast(ctl.get(), STOP) ==》 A
//                           ||
//                            (
//                              这里写成这样，可能是怕线程的中断不是因为线程池关闭了需要将线程中断，而是开发者在线程的run方法中手动中断线程
//                              所以使用静态interrupted方法清除中断标志位，并再一次检查运行状态
//                              Thread.interrupted() && runStateAtLeast(ctl.get(), STOP)  ==》 B
//                            )
//                          ) &&
//                            !wt.isInterrupted()
//                       )
//        调用interrupt()方法仅仅是在当前线程中打了一个停止的标记，并不是真正的停止线程
//        静态interrupted()测试当前线程是否已经是中断状态，执行后具有清除中断状态flag的功能
//        isInterrupted()测试线程Thread对象是否已经是中断状态，但不清除中断状态flag
//                        wt.interrupt();
//                    try {
//                        beforeExecute(wt, task);
//                        Throwable thrown = null;
//                        try {
//                            task.run();
//                        } catch (RuntimeException x) {
//                            thrown = x; throw x;
//                        } catch (Error x) {
//                            thrown = x; throw x;
//                        } catch (Throwable x) {
//                            thrown = x; throw new Error(x);
//                        } finally {
//                            afterExecute(task, thrown);
//                        }
//                    } finally {
//                        task = null;
//                        w.completedTasks++;
//                        w.unlock();
//                    }
//                }
//                completedAbruptly = false;
//            } finally {
//                通过 completedAbruptly 标志位判断是不是因为beforeExecute(wt, task)、afterExecute(task, thrown)抛异常导致的线程退出
//                如果是因为beforeExecute(wt, task)、afterExecute(task, thrown)抛异常导致的非中断退出
//                则这个completedAbruptly会为true，即该工作线程是因为开发者的代码bug异常而挂了的
//                processWorkerExit(w, completedAbruptly);
//            }
//        }
//
//        private void processWorkerExit(ThreadPoolExecutor.Worker w, boolean completedAbruptly) {
//            if (completedAbruptly) 如果是因为开发者自己的异常问题，导致的线程退出，则将工作线程数 - 1
//                decrementWorkerCount();
//
//            final ReentrantLock mainLock = this.mainLock;
//            mainLock.lock();
//            try {
//                completedTaskCount += w.completedTasks;
//                workers.remove(w);
//            } finally {
//                mainLock.unlock();
//            }
//
//            tryTerminate();
//
//            int c = ctl.get();
//            if (runStateLessThan(c, STOP)) {
//
//                if (!completedAbruptly) {
//                    int min = allowCoreThreadTimeOut ? 0 : corePoolSize;
//                    if (min == 0 && ! workQueue.isEmpty())
//                        min = 1;
//                    if (workerCountOf(c) >= min)
//                        return; // replacement not needed
//                }
//        如果是因为开发者自己的异常问题，导致的线程退出，或者
//        当前的工作线程已经小于 MIN 了，就补充一个工作线程来干活
//                addWorker(null, false);
//            }
//        }
    }
}
