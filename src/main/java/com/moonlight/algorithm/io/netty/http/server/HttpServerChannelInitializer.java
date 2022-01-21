package com.moonlight.algorithm.io.netty.http.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 *
 * @author Moonlight
 */
public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new HttpResponseEncoder())
                          .addLast(new HttpRequestDecoder())
                          .addLast(new HttpServerHandler());
    }
}