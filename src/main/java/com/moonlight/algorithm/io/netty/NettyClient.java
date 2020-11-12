package com.moonlight.algorithm.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @ClassName NettyClient
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/11 21:53
 * @Version V1.0
 **/
public class NettyClient {

    public void standardNettyClient() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MyHandler());
                    }
                })
                .connect(new InetSocketAddress(9090));

        Channel client = connect.sync().channel();

        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(buf);
        send.sync();

        client.closeFuture().sync();
    }

    public void myClient() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);

        NioSocketChannel client = new NioSocketChannel();

        group.register(client);

        client.pipeline().addLast(new MyHandler());

        ChannelFuture sync = client.connect(new InetSocketAddress(8888)).sync();
        sync.sync();

        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(buf);
        send.sync();

        sync.channel().closeFuture().sync();

        System.out.println("client disconnect");
    }

    @ChannelHandler.Sharable
    static class ChannelInitHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            Channel client = ctx.channel();
            client.pipeline().addLast(new MyHandler());
            ctx.pipeline().remove(this);
        }

    }

    static class MyHandler extends ChannelInitHandler {
        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("client registered");
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("client active");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;

            CharSequence str = buf.getCharSequence(0,buf.readableBytes(), CharsetUtil.UTF_8);

            System.out.println("client read: " + str);

            ctx.writeAndFlush("client read: " + buf);
        }

    }

}
