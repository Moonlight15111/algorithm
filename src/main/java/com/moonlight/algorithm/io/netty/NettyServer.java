package com.moonlight.algorithm.io.netty;

import com.mysql.fabric.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @ClassName NettyServer
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/11 22:10
 * @Version V1.0
 **/
public class NettyServer {

    public void standardNettyServer() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ChannelFuture bind = serverBootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                                  @Override
                                  protected void initChannel(NioSocketChannel ch) throws Exception {
                                      ch.pipeline().addLast(new NettyClient.MyHandler());
                                  }
                              }
                )
                .bind(8888);
        bind.sync().channel().closeFuture().sync();
    }

    public void myServer() throws Exception {
        // 事件循环组
        NioEventLoopGroup group = new NioEventLoopGroup(1);

        // Server
        ServerSocketChannel channel = new NioServerSocketChannel();

        // 注册
        group.register(channel);

        channel.pipeline().addLast(new MyServerHandle(group, new NettyClient.ChannelInitHandler()));

        // 绑定
        ChannelFuture bind = channel.bind(new InetSocketAddress(8888));

        bind.sync().channel().closeFuture().sync();
        System.out.println("server close");
    }

    static class MyServerHandle extends ChannelInboundHandlerAdapter {

        private EventLoopGroup group;
        private NettyClient.ChannelInitHandler channelInitHandler;

        public MyServerHandle(EventLoopGroup group, NettyClient.ChannelInitHandler channelInitHandler) {
            this.group = group;
            this.channelInitHandler = channelInitHandler;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            SocketChannel client = (SocketChannel) msg;

            client.pipeline().addLast(channelInitHandler);

            group.register(client);
        }
    }

}
