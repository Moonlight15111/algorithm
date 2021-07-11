package com.moonlight.algorithm.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SourceCodeLearn
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/25 20:52
 * @Version V1.0
 **/
public class ThreadPoolExecutorSourceCode {

    public void threadKeepAliveAndGetTask() {
        /*
ctl: 高三位表示线程池运行状态: Running、SHUTDOWN、STOP、TIDYING、TERMINATED  低29位存工作的线程数

 RUNNING:  Accept new tasks and process queued tasks  接收新任务，同时也会处理任务队列中的任务
 SHUTDOWN: Don't accept new tasks, but process queued tasks  不接受新任务，但是会处理任务队列中的任务
 STOP:     Don't accept new tasks, don't process queued tasks and interrupt in-progress tasks  不接受新任务，也不处理任务队列里的任务，还要中断正在执行中的任务
 TIDYING:  All tasks have terminated, workerCount is zero the thread transitioning to state TIDYING will run the terminated() hook method  所有的任务都已经终止，且工作线程数量为0，就会转换状态到tidying 然后调terminated 钩子函数
 TERMINATED: terminated() has completed  terminated方法已经执行完毕

  存放线程对象的容器为什么使用HashSet HashSet 其实本质上就是 HashMap ThreadPoolExecutor中对worker集合(HashSet)只有add和remove操作
  这些操作对于HashSet来说时间复杂度均为O(1)，而且线程数中对线程进入集合的顺序和优先级都没有要求，跟其他集合类相比，
  在空间复杂度一致的情况下，当然是时间复杂度最好的集合类优先考虑 另一个可能是为保证唯一性，即同一个线程只往里面放一次

  由于工作队列，是多线程共享的，所以它应该是要多线程并发安全的，另外因为工作线程在没有任务的时候需要等着放任务，所以它需要对线程进行阻塞
  综上，应该选择blockingQueue

  CPU 密集型计算：多线程本质上是提升多核 CPU 的利用率，所以一般都是一个核一个线程，或者设置 核心数 + 1也行，
  这样的话，当线程因为偶尔的内存页失效或其他原因导致阻塞时，这个额外的线程可以顶上，从而保证 CPU 的利用率。

  I/O 密集型的计算场景：如果 CPU 计算和 I/O 操作的耗时是1:1，那么 2 个线程是最合适的。
  如果 CPU 计算和 I/O 操作的耗时是 1:2，设置 3 个线程好一点，这样子 CPU 在 A、B、C 三个线程之间切换，
  对于线程 A，当 CPU 从B、C 切换回来时，线程 A 正好执行完 I/O 操作。
  这样 CPU 和 I/O 设备的利用率都达到了100%。

  一般一个线程执行完任务之后就结束了，Thread.start()只能调用一次，一旦这个调用结束，则该线程就到了stop状态，不能再次调用start。
  如果你对一个已经启动的线程对象再调用一次start方法的话,会产生:IllegalThreadStateException异常，但是Thread的run方法是可以重复调用的。

  worker: 继承自AQS，实现了Runnable接口。因为worker有很多状态需要记录，外面丢进来的任务是没有的，而且需要一个线程来运行，所以用runnable包装了一次。worker里面
          会记录当前执行任务的线程，多线程的情况下，为了保障这个记录的准确性，也为了防止出现执行任务过程中，被其他线程抢断的情况，所以需要加锁于是用了AQS

    private Runnable getTask() {
         // Are workers subject to culling?
         boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;

         如果：
            1. 工作线程数已经超过了最大线程数 或 获取任务时已经等待超时了 且 (允许核心线程超时 或 当前工作线程数超出了核心线程数)
            且
            2. 当前最少还有一个工作线程 或 已经没有任务了
         那么就先对工作线程数减1 然后return
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

当任务队列是一个无界队列时，其实最大线程数、keepAliveTime、TimeUnit这几个参数就没多大意义了，因为任务队列可能永远都有任务
线程池可能永远都会处于满负荷运行态

核心线程为什么不死 ?
  通过任务队列workQueue.take()阻塞，让线程一直等待，直到获取到任务

如何释放核心线程 ?
  将allowCoreThreadTimeOut设置为true



由以上源码可知线程池其实并不区分核心线程与非核心线程，只是根据当前线程池容量状态做不同的处理来进行调整，
0 - corePoolSize 表示线程池里只有核心线程，corePoolSize - maximumPoolSize 表示线程池里核心线程已满，存在非核心线程
所以corePoolSize只是线程池希望并保持的并发状态  corePoolSize - maximumPoolSize只是线程池允许的并发的超载状态，不希望长期保持。

corePoolSize 只在:
 1. 添加工作线程时，判断一下核心线程是不是满了，没满就起个核心线程
 2. 获取任务进行等待时，作为是否需要释放工作线程的判断条件之一
 3. 处理线程退出，作为最小线程数的取值之一
这几个地方有重要作用
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
//        Worker(Runnable firstTask) {
//            setState(-1); 初始设置为-1是为了防止出现线程还没有启动就被中断的情况
//            this.firstTask = firstTask;
//            this.thread = getThreadFactory().newThread(this);
//        }
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
//                    这个加锁其实为了标识这个线程是不是空闲线程
//                    在interruptIdleWorkers()方法中断空闲线程时会尝试去获取线程的锁，能拿到锁就中断这个线程
//                    如果这个线程在干活自己就拿不到锁，那就表示它不是一个空闲线程咯
//                    w.lock();
//                    // If pool is stopping, ensure thread is interrupted;
//                    // if not, ensure thread is not interrupted.  This
//                    // requires a recheck in second case to deal with
//                    // shutdownNow race while clearing interrupt
//                    如果：
//                       线程池已经进入STOP、TIDYING、TERMINATED状态了
//                       或者 当前线程已经被中断过了且线程池已经进入STOP、TIDYING、TERMINATED状态了
//                       但是当前工作线程并没有被中断(因为上面那个判断线程是否被中断过会消耗一个中断标志位，即线程之前被中断过走了Thread.interrupted()后就会置为非中断态)，
//                       则手动将当前工作线程中断
//                    正如注释所说，只有当线程池正在进行关闭操作，线程才应该处于中断状态
//                    if ( (runStateAtLeast(ctl.get(), STOP) ==》 A
//                           ||
//                            (
//                              这里写成这样，应该是说，如果你之前被中断过，那么线程池就应该至少处于stop状态，否则就清掉你这个中断标志
//                              可能是怕线程的中断不是因为线程池关闭了需要将线程中断，而是开发者在线程的run方法中中断了线程
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

    public void shutdownAndNow() {
//        public void shutdown() {
//            final ReentrantLock mainLock = this.mainLock;
//            mainLock.lock();
//            try {
//                checkShutdownAccess();
//                改变线程池的状态为Shutdown
//                advanceRunState(SHUTDOWN);
//                释放空闲的线程，这是很符合shutdown的定义的，shutdown是指不接受新的任务，但是继续执行任务队列里面剩余的任务
//                所以既然你都已经空闲了，说明你没有事可以做了，那就关了呗，留着也没啥用
//                interruptIdleWorkers();
//                钩子函数，正式关闭前想做点什么，比如释放资源之类的
//                onShutdown(); // hook for ScheduledThreadPoolExecutor
//            } finally {
//                mainLock.unlock();
//            }
//            tryTerminate();
//        }

//        public List<Runnable> shutdownNow() {
//            List<Runnable> tasks;
//            final ReentrantLock mainLock = this.mainLock;
//            mainLock.lock();
//            try {
//                checkShutdownAccess();
//                改变线程池的状态为STOP
//                advanceRunState(STOP);
//                中断所有的工作线程，这是很符合stop的定义的，stop是指不接受新任务，也不执行任务队列里面剩下的任务，同时中断所有正在执行的任务
//                interruptWorkers();
//                可能调用者想要知道哪些任务还没有被执行，所以返回这些任务，对其进行补偿？
//                tasks = drainQueue();
//                可能是因为这个方法叫shutdownNow，表示很急，所以没必要放个钩子在这里？
//            } finally {
//                mainLock.unlock();
//            }
//            tryTerminate();
//            return tasks;
//        }
    }

    public void tryTerminate() {
//        final void tryTerminate() {
//            for (;;) {
//                int c = ctl.get();
//                如果当前:
//                        1. 是运行状态 或者 2. 已经进入了tidying、terminate状态 或者 3. 是shutdown状态 且 任务队列还有任务
//                那么就直接return掉
//                if (isRunning(c) ||
//                        runStateAtLeast(c, TIDYING) ||
//                        (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()))
//                    return;
//                如果当前还有工作线程在跑，那么就只中断一个，可能是怕没有线程执行下面的terminated()方法？
//                因为能走到这里来的前面都做过线程数量 - 1 操作了，如果所有的线程都中断掉，那么谁来执行terminated()呢？
//                所以这里是为了保证只有最后一个线程后往下面走执行terminated
//                if (workerCountOf(c) != 0) { // Eligible to terminate
//                    interruptIdleWorkers(ONLY_ONE);
//                    return;
//                }
//
//                final ReentrantLock mainLock = this.mainLock;
//                mainLock.lock();
//                try {
//                    if (ctl.compareAndSet(c, ctlOf(TIDYING, 0))) {
//                        try {
//                            terminated();
//                        } finally {
//                            ctl.set(ctlOf(TERMINATED, 0));
//                            唤醒所有的等待terminated的线程，即调了awaitTerminated()方法的线程
//                            termination.signalAll();
//                        }
//                        return;
//                    }
//                } finally {
//                    mainLock.unlock();
//                }
//                // else retry on failed CAS
//            }
//        }
//        private List<Runnable> drainQueue() {
//            BlockingQueue<Runnable> q = workQueue;
//            ArrayList<Runnable> taskList = new ArrayList<Runnable>();
//            在正常情况下使用drainTo，但是如果队列是一个延迟队列或者其他种类的队列比如说不支持drainTo方法那么这个drainTo可能会失败
//            所以需要在下面又重新手动搞过一次
//            q.drainTo(taskList);
//            if (!q.isEmpty()) {
//                for (Runnable r : q.toArray(new Runnable[0])) {
//                    if (q.remove(r))
//                        taskList.add(r);
//                }
//            }
//            return taskList;
//        }
    }

}
