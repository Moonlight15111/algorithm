package com.moonlight.algorithm.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SelectorThreadGroup
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/9 22:00
 * @Version V1.0
 **/
public class SelectorThreadGroup {

    protected SelectorThread[] sts;

    protected ServerSocketChannel serverSocketChannel;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private SelectorThreadGroup worker;

    public void setWorker(SelectorThreadGroup worker) {
        this.worker = worker;
    }

    public SelectorThreadGroup(int num) {
        this.init(num);
    }

    public void init(int num) {
        this.sts = new SelectorThread[num];
        this.worker = this;
        for (int i = 0; i < num; i++) {
            this.sts[i] = new SelectorThread(this);
            new Thread(this.sts[i]).start();
        }
    }

    public void bind(int port) {
        try {
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.configureBlocking(false);
            this.serverSocketChannel.bind(new InetSocketAddress(port));

            nextSelectorV2(this.serverSocketChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nextSelectorV2(Channel c) {
        try {
            if (c instanceof  ServerSocketChannel) {
                SelectorThread st = next();
                st.channelList.put(c);
                st.setGroup(worker);
                // 那边启动的时候会阻塞
                st.selector.wakeup();
            } else {
                SelectorThread st = nextV2();
                st.channelList.add(c);
                st.selector.wakeup();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private SelectorThread nextV2() {
        int index = atomicInteger.incrementAndGet() % worker.sts.length;
        return worker.sts[index];
    }

    public void nextSelector(Channel c) {
        SelectorThread st = next();
        st.channelList.add(c);
        st.selector.wakeup();
    }

    private SelectorThread next() {
        int index = atomicInteger.incrementAndGet() % sts.length;
        return sts[index];
    }
}
