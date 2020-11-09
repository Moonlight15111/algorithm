package com.moonlight.algorithm.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName SelectorThread
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/9 21:51
 * @Version V1.0
 **/
public class SelectorThread implements Runnable {

    protected Selector selector;

    protected SelectorThreadGroup group;

    protected BlockingQueue<Channel> channelList = new LinkedBlockingQueue<>();

    public SelectorThread(SelectorThreadGroup group) {
        try {
            this.group = group;
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                int select = this.selector.select();

                if (select > 0) {
                    Set<SelectionKey> keys = this.selector.selectedKeys();
                    Iterator<SelectionKey> iter = keys.iterator();
                    while (iter.hasNext()) {
                        SelectionKey next = iter.next();
                        iter.remove();
                        if (next.isAcceptable()) {
                            acceptHandle(next);
                        } else if (next.isReadable()) {
                            readHandle(next);
                        } else if (next.isWritable()) {
                            writeHandle(next);
                        }
                    }
                }

                if (!channelList.isEmpty()) {
                    Channel c = channelList.take();
                    if (c instanceof ServerSocketChannel) {
                        ServerSocketChannel server = (ServerSocketChannel) c;
                        server.register(selector, SelectionKey.OP_ACCEPT);

                        System.out.println(Thread.currentThread().getName() + " register ");
                    } else if (c instanceof  SocketChannel) {
                        SocketChannel client = (SocketChannel) c;
                        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
                        client.register(selector, SelectionKey.OP_READ, buffer);

                        System.out.println(Thread.currentThread().getName()+" register client: " + client.getRemoteAddress());
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setGroup(SelectorThreadGroup group) {
        this.group = group;
    }

    private void readHandle(SelectionKey next) {
        ByteBuffer byteBuffer = (ByteBuffer) next.attachment();
        SocketChannel channel = (SocketChannel) next.channel();
        byteBuffer.clear();
        while (true) {
            try {
                int read = channel.read(byteBuffer);
                if (read > 0) {
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        channel.write(byteBuffer);
                    }
                    byteBuffer.clear();
                } else if (read == 0) {
                    break;
                } else {
                    System.out.println("client " + channel.getRemoteAddress() + " disconnection");
                    next.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void acceptHandle(SelectionKey next) {
        ServerSocketChannel socketChannel = (ServerSocketChannel) next.channel();
        try {
            SocketChannel accept = socketChannel.accept();
            accept.configureBlocking(false);

            group.nextSelectorV2(accept);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHandle(SelectionKey next) {
        System.out.println("write handle nothing to write ");
    }
}
