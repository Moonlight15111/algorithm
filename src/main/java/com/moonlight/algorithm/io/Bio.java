package com.moonlight.algorithm.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Bio
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/14 13:27
 * @Version V1.0
 **/
public class Bio {

    public static void main(String[] args) throws IOException {
        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // ServerSocket监听8888端口
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8888));
        // 主线程死循环等待连接
        while(true) {
            // 同步阻塞点
            Socket socket = serverSocket.accept();
            // 为每个连接都创建新的线程
            executor.submit(new ConnectHandler(socket));
        }
    }

}
class ConnectHandler extends Thread {
    private Socket socket;
    public ConnectHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        // 死循环处理读写事件
        while(!socket.isClosed()){
            // 1.读取数据 - 同步阻塞点
//            socket.read();
            // 2.处理读取到数据
            // 3.写数据,对请求做出响应 - 同步阻塞点
//            socket.write();
        }
    }
}