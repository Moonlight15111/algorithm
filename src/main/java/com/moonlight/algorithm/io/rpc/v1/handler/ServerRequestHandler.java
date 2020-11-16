package com.moonlight.algorithm.io.rpc.v1.handler;

import com.moonlight.algorithm.io.rpc.v1.SerializeUtil;
import com.moonlight.algorithm.io.rpc.v1.Test;
import com.moonlight.algorithm.io.rpc.v1.entity.Msg;
import com.moonlight.algorithm.io.rpc.v1.entity.MyContent;
import com.moonlight.algorithm.io.rpc.v1.entity.MyHeader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName ServerRequestHandler
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 22:24
 * @Version V1.0
 **/
public class ServerRequestHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Msg myMsg = (Msg) msg;
        String ioThreadName = Thread.currentThread().getName();
        ctx.executor().parent().next().execute(() -> {
            Test.Car car = new Test.Bmw();

            String dudu = car.dudu((String) myMsg.getContent().getArgs()[0]);

            String res = "ioThreadName: " + ioThreadName + "  execThreadName: " + Thread.currentThread().getName() + " res: " + dudu;
            byte[] out = SerializeUtil.out(new MyContent().setRes(res));

            MyHeader resHead = new MyHeader().setDataLength(out.length).setFlag(0x11111112).setRequestId(myMsg.getHeader().getRequestId());
            byte[] headOut = SerializeUtil.out(resHead);

            ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(headOut.length + out.length);
            byteBuf.writeBytes(headOut).writeBytes(out);

            ctx.writeAndFlush(byteBuf);
        });
    }
}
