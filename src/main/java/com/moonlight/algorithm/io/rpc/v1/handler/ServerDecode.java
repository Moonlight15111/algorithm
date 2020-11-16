package com.moonlight.algorithm.io.rpc.v1.handler;

import com.moonlight.algorithm.io.rpc.v1.entity.Msg;
import com.moonlight.algorithm.io.rpc.v1.entity.MyContent;
import com.moonlight.algorithm.io.rpc.v1.entity.MyHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @ClassName ServerDecode
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 22:00
 * @Version V1.0
 **/
public class ServerDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 122) {
            // 取header,但是指针不移动到对应的位置，只是单纯的读取前110个字节
            byte[] bytes = new byte[122];
            in.getBytes(in.readerIndex(), bytes);
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);
            MyHeader header = (MyHeader) objectInputStream.readObject();

            if (in.readableBytes() >= header.getDataLength()) {
                // 移动指针到body开始的位置
                in.readBytes(122);
                byte[] data = new byte[(int) header.getDataLength()];
                in.readBytes(data);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
                ObjectInputStream objectInputStream1 = new ObjectInputStream(byteArrayInputStream);

                if (header.getFlag() == 0x11111111) {
                    MyContent content = (MyContent) objectInputStream1.readObject();
                    out.add(new Msg().setHeader(header).setContent(content));
                } else if (header.getFlag() == 0x11111112) {
                    MyContent content = (MyContent) objectInputStream1.readObject();
                    out.add(new Msg().setHeader(header).setContent(content));
                }
            } else {
                break;
            }
        }
    }
}
