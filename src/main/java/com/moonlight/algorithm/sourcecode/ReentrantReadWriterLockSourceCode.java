package com.moonlight.algorithm.sourcecode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReentrantReadWriterLockSourceCode
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/16 13:49
 * @Version V1.0
 **/
public class ReentrantReadWriterLockSourceCode {
    /*
     读锁
     private final ReentrantReadWriteLock.ReadLock readerLock;
     写锁
     private final ReentrantReadWriteLock.WriteLock writerLock;
     同步器
     final Sync sync;
    */

    private void syncInnerClass() {
        /*

     abstract static class Sync extends AbstractQueuedSynchronizer {
        高16位表示读锁
        static final int SHARED_SHIFT   = 16;
        对16位进行操作，比如 加 1 减 1
        static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
        最大读锁数量
        static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
        互斥锁在低16位，这个字段用来获取低16位的值
        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
        计算共享锁(读锁)的数量
        static int sharedCount(int c) {
           return c >>> SHARED_SHIFT;
        }
        计算排他锁(写锁)的数量
        static int exclusiveCount(int c) {
            return c & EXCLUSIVE_MASK;
        }
        读锁重入计数器，通过ThreadLocal来统计每个线程对于读锁重入的的次数，每个线程统计自己的
        static final class HoldCounter {
            int count = 0;
            // Use id, not reference, to avoid garbage retention
            final long tid = getThreadId(Thread.currentThread());
        }
        继承自ThreadLocal 重写initialValue方法，在线程第一次获取该变量时调用，初始化重入计数器
        static final class ThreadLocalHoldCounter extends ThreadLocal<ReentrantReadWriteLock.Sync.HoldCounter> {
            public ReentrantReadWriteLock.Sync.HoldCounter initialValue() {
                return new ReentrantReadWriteLock.Sync.HoldCounter();
            }
        }
        创建ThreadLocal对象
        private transient ThreadLocalHoldCounter readHolds;
        缓存最后一个线程获取的读锁数量
        private transient HoldCounter cachedHoldCounter;
        第一个获取到读锁的线程
        private transient Thread firstReader = null;
        第一个获取到读锁的线程的重入次数
        private transient int firstReaderHoldCount;

        构造方法中初始化重入计数器ThreadLocal对象
        Sync() {
          readHolds = new ThreadLocalHoldCounter();
          setState(getState()); // ensures visibility of readHolds
        }

        protected final boolean tryAcquire(int acquires) {

          Thread current = Thread.currentThread();
          int c = getState();
          写锁的数量
          int w = exclusiveCount(c);
          有线程获取到了锁
          if (c != 0) {
              如果写锁的数量为0，则说明有线程获取到了读锁
              如果写锁数量不为0，且当前线程不是持有锁的线程，那么说明是有线程获取到了写锁
              因为读写互斥，写写互斥，所以需要立即返回false，让这个写线程滚去排队
              if (w == 0 || current != getExclusiveOwnerThread())
                  return false;
              走到这里就说明是写锁重入
              if (w + exclusiveCount(acquires) > MAX_COUNT)
                  throw new Error("Maximum lock count exceeded");
              // Reentrant acquire
              setState(c + acquires);
              return true;
          }
          没有任何线程获取到锁，即没有读锁也没有写锁
          if (writerShouldBlock() 子类实现判断当前线程是否应该获取写锁（公平锁、非公平锁）
              || !compareAndSetState(c, c + acquires)) 通过CAS来抢写锁
              return false;
          抢锁成功了，就把当前线程设置为锁的持有者
          setExclusiveOwnerThread(current);
          return true;
      }

      protected final int tryAcquireShared(int unused) {
        Thread current = Thread.currentThread();
        int c = getState();
        if (exclusiveCount(c) != 0 && 已经有写锁了 且 当前线程并不是锁的持有者 则返回 -1 表示获取锁失败，这个线程应该滚去排队
                getExclusiveOwnerThread() != current)
            return -1;
        获取读锁的数量
        int r = sharedCount(c);
        if (!readerShouldBlock() && 如果读锁不应该阻塞 且 读锁还未达到上线 且 获取锁成功
                r < MAX_COUNT &&
                compareAndSetState(c, c + SHARED_UNIT)) {
            说明这是第一个获取到读锁的线程
            if (r == 0) {
                firstReader = current;
                firstReaderHoldCount = 1;
            说明第一个获取到读锁的线程在做重入
            } else if (firstReader == current) {
                firstReaderHoldCount++;
            } else {
                更新最后一个获取到读锁的线程的重入计数缓存
                ReentrantReadWriteLock.Sync.HoldCounter rh = cachedHoldCounter;
                if (rh == null || rh.tid != getThreadId(current))
                    cachedHoldCounter = rh = readHolds.get();
                else if (rh.count == 0)
                    readHolds.set(rh);
                更新重入次数
                rh.count++;
            }
            return 1;
        }

        return fullTryAcquireShared(current);
    }

        */
    }

}