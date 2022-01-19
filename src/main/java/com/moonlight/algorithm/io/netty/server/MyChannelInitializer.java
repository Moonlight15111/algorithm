package com.moonlight.algorithm.io.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Moonlight
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        // 基于换行符号
//        channel.pipeline().addLast("lineBasedFrameDecoder", new LineBasedFrameDecoder(1024));
        // 基于指定字符串【使用Delimiters.lineDelimiter()默认按照换行符，这样功能等同于LineBasedFrameDecoder】
//        channel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false,
//                Unpooled.wrappedBuffer(new byte[] { 'a', 'b' }),
//                Unpooled.wrappedBuffer(new byte[] { 'c' })));
        // 基于长度, 这种对于中文或其他多字节的文字容易乱码，比如：中文发送: 呀滧燚安抚覅激发
         channel.pipeline().addLast(new FixedLengthFrameDecoder(4));

        channel.pipeline().addLast("stringDecoder", new StringDecoder(StandardCharsets.UTF_8));
        channel.pipeline().addLast("myServerDecoder", new MyServerHandler());
    }
}
