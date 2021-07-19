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
                    // 将要处理的事件从返回的事件结果集移除掉，防止重复处理
                    iter.remove();
                    if (key.isAcceptable()) {
                        // 处理连接事件
                        // 这里需要注意的时,accept是接受新的连接并返回新连接的fd
                        // 所以需要将新的fd进行注册
                        acceptHandler(key, selector);
                    } else if (key.isReadable()) {
                        // 读取并处理数据
                        // 在多路复用器中cancel掉这个key
                        // 因为即使抛出另一个线程来处理，在另一个线程创建出来并启动的这个时间差里，这个key的read事件可能会被重复触发
                        key.cancel();
                    } else if (key.isWritable()) {
                        // 写数据
                        // 写事件，只要SendQueue是空的，就一定会给你返回可以写的事件，就会回调写事件方法
                        // 另外你需要先准备好要写什么，然后才关心SendQueue是否有空间
                        // 所以read一开始就要注册，但是writer依赖以上关系，所以是什么用什么时候注册
                        // 因为只要SendQueue是空的，就一定会返回可以写的事件，所以注册write事件后
                        //
                        key.cancel();
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
