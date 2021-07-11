package com.moonlight.algorithm.io.iomode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName Multiplexing
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/14 16:32
 * @Version V1.0
 **/
public class Multiplexing {

    public void start() throws Exception {
        // ServerSocket监听8888端口
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(8888));
        // 注册Selector   epoll模型下: epoll_create
        Selector selector = Selector.open();
        // select、poll模型下: 可能是开辟一个数组用来存放fd epoll模型下: epoll_ctl
        server.register(selector, SelectionKey.OP_ACCEPT);
        // 死循环
        while (true) {
            // 调用内核的select、poll,或者epoll_wait
            while (selector.select() > 0) {
                // 获取有状态的fd集合,即可用的fd
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();
                    if (key.isAcceptable()) {
                        // 处理连接事件
                        // 这里需要注意的时,accept是接受新的连接并返回新连接的fd
                        // 所以需要将新的fd进行注册
                        acceptHandler(key, selector);
                    } else if (key.isReadable()) {
                        // 读取并处理数据
                    } else if (key.isWritable()) {
                        // 写数据
                    }
                }
            }
        }
    }

    public void acceptHandler(SelectionKey key, Selector selector) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(2048);
            client.register(selector, SelectionKey.OP_READ, buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;
        try {
            while (true) {
                read = client.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if (read == 0) {
                    break;
                } else {
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
