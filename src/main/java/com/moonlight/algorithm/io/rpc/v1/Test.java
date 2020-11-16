package com.moonlight.algorithm.io.rpc.v1;

import com.moonlight.algorithm.io.rpc.v1.handler.ServerDecode;
import com.moonlight.algorithm.io.rpc.v1.handler.ServerRequestHandler;
import com.moonlight.algorithm.io.rpc.v1.proxy.MyProxy;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 22:20
 * @Version V1.0
 **/
public class Test {
    public static void startServer() {
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker =  new NioEventLoopGroup(5);

        ServerBootstrap sbs = new ServerBootstrap();
        ChannelFuture bind = sbs.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        System.out.println("server accept client port: " + ch.remoteAddress().getPort());
                        ch.pipeline().addLast(new ServerDecode()).addLast(new ServerRequestHandler());
                    }
                }).bind(new InetSocketAddress("localhost", 8888));
        try {
            bind.sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(Test::startServer).start();
        AtomicInteger  num = new AtomicInteger(0);
        int size = 50;
        Thread[] threads = new Thread[size];
        for (int i = 0; i <size; i++) {
            threads[i] = new Thread(()->{
                Car car = MyProxy.proxyGet(Car.class);//动态代理实现   //是真的要去触发 RPC调用吗？
                String arg = " this " + num.incrementAndGet();
                String res = car.dudu(arg);
                System.out.println("client over msg: " + res + " src arg: " + arg);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public interface Car {
        String dudu(String dudu);
    }
    public static class Bmw implements Car {

        @Override
        public String dudu(String dudu) {
            return "bie mo wo " + dudu;
        }
    }

}