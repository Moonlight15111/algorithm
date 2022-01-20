package com.moonlight.algorithm.io.netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Moonlight
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        ChannelGroupUtil.channelGroup.add(channel);

        String msg = "服务端 - 收到客户端链接请求: " + channel.remoteAddress();
        System.out.println(msg);
        channel.writeAndFlush(msg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开链接" + ctx.channel().localAddress().toString());
        // 当有客户端退出后，从channelGroup中移除。
        ChannelGroupUtil.channelGroup.remove(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            String ret = " 服务端 - 接收到消息: " + msg;

            System.out.println(ret);

            ChannelGroupFuture writeAndFlush = ChannelGroupUtil.channelGroup.writeAndFlush(ret);
//            ChannelFuture writeAndFlush = ctx.writeAndFlush(ret);
            writeAndFlush.sync();
            System.out.println("服务端 - send msg result: " + writeAndFlush.isSuccess());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    /**
     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        String msg = "服务端发生异常: " + cause;
        System.out.println(msg);
        ctx.writeAndFlush(msg);
        ctx.close();
    }

}
