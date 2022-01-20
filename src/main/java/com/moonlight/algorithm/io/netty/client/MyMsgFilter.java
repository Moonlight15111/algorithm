package com.moonlight.algorithm.io.netty.client;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 *
 * @author Moonligh
 */
@ChannelHandler.Sharable
public class MyMsgFilter extends ChannelOutboundHandlerAdapter {

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " - " + ctx.channel().localAddress() + " 接收到一条消息");
//        ctx.writeAndFlush(ctx.channel().remoteAddress() + " - " + ctx.channel().localAddress() + " 接收到一条消息");
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " - " + ctx.channel().localAddress() + " 发出去一条消息");
//        ctx.writeAndFlush(ctx.channel().remoteAddress() + " - " + ctx.channel().localAddress() + " 发出去一条消息");
        super.write(ctx, msg, promise);
    }

}
