package com.moonlight.algorithm.io.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * @author Moonlight
 */
public class NettyClient {

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient();
        client.start();
        client.clientOption();
    }

    private final EventLoopGroup clientGroup;
    private final Bootstrap bootstrap;
    private Channel channel;

    public NettyClient() {
        this.clientGroup = new NioEventLoopGroup();
        this.bootstrap = new Bootstrap();
    }

    public void start() throws Exception {
        bootstrap
                .group(clientGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new MyClientChannelInitializer());

        ChannelFuture future = bootstrap.connect("localhost", 8081).sync();

        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                System.out.println("连接服务器成功");
            } else {
                System.out.println("连接服务器失败");
                future1.cause().printStackTrace();
                clientGroup.shutdownGracefully(); // 关闭线程组
            }
        });
        this.channel = future.channel();
    }

    public void send(String message) {
        ChannelFuture writeAndFlush = this.channel.writeAndFlush(message);
        try {
            writeAndFlush.sync();
            System.out.println("客户端 - client send() msg result: " + writeAndFlush.isSuccess());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        send("client closed");
        clientGroup.shutdownGracefully();// 关闭当前的线程组
    }

    public void clientOption() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入: ");
            String nextLine = scanner.nextLine();
            if ("quit".equalsIgnoreCase(nextLine)) {
                break;
            }
            send(nextLine);
        }
        close();// 关闭当前的客户端
    }
}