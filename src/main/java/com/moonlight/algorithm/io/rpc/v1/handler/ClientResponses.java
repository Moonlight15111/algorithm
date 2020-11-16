package com.moonlight.algorithm.io.rpc.v1.handler;

import com.moonlight.algorithm.io.rpc.v1.entity.Msg;
import com.moonlight.algorithm.io.rpc.v1.response.ResponseCallBack;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName ClientResponses
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 22:00
 * @Version V1.0
 **/
public class ClientResponses extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ResponseCallBack.runCallBack((Msg) msg);
    }
}
