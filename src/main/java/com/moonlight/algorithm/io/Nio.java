package com.moonlight.algorithm.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Nio
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/14 15:39
 * @Version V1.0
 **/
public class Nio {

    public static void main(String[] args) throws IOException {
        List<SocketChannel> clients = new ArrayList<>();
        // ServerSocket监听8888端口
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(8888));
        // 设置非阻塞
        ss.configureBlocking(false);
        // 死循环等待连接
        while (true) {
            SocketChannel client = ss.accept();
            if (client != null) {
                // 设置非阻塞 - 这里是另一个socket - 服务端监听有一个socket, 连接请求三次握手后通过accept得到一个连接的socket,这个连接的socket用于读写连接后的数据
                client.configureBlocking(false);
                clients.add(client);
            }
            // 遍历已经连接进来的客户端能不能读写数据
            for (SocketChannel c : clients) {
                // 1.读取数据：  > 0  -1  0
//                int num = c.read();

//                if (num > 0) {
//                    // 2.处理数据
//                    // 3.写数据
//                    c.write();
//                }
            }
        }
    }

}
