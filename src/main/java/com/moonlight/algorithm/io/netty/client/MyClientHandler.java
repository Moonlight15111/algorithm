package com.moonlight.algorithm.io.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Moonlight
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            String retMsg = " 客户端 - 接收到消息: " + msg;

            System.out.println(retMsg);

//            ChannelFuture writeAndFlush = ctx.writeAndFlush(retMsg);
//            writeAndFlush.sync();
//            System.out.println("客户端 - handler channel read send msg result: " + writeAndFlush.isSuccess());
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        System.out.println("客户端 - 链接至服务器");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        String msg = "客户端 - 出现异常: \r\n" + cause;
        System.out.println(msg);
        ctx.writeAndFlush(msg);
        ctx.close();
    }

}
