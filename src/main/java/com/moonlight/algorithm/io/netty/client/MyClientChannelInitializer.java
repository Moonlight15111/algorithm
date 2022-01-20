package com.moonlight.algorithm.io.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Moonlight
 */
public class MyClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                .addLast("myClientStringEncoder", new StringEncoder(StandardCharsets.UTF_8))
                .addLast("myClientStringDecoder", new StringDecoder(StandardCharsets.UTF_8))
                .addLast("myClientMsgFilter", new MyMsgFilter())
                .addLast("myClientHandler", new MyClientHandler());
    }

}
