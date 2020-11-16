package com.moonlight.algorithm.io.rpc.v1.proxy;

import com.moonlight.algorithm.io.rpc.v1.SerializeUtil;
import com.moonlight.algorithm.io.rpc.v1.client.ClientFactory;
import com.moonlight.algorithm.io.rpc.v1.entity.MyContent;
import com.moonlight.algorithm.io.rpc.v1.entity.MyHeader;
import com.moonlight.algorithm.io.rpc.v1.response.ResponseCallBack;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName MyProxy
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 20:38
 * @Version V1.0
 **/
public class MyProxy {


    public static <T> T proxyGet(Class<T> carClass) {
        return (T) Proxy.newProxyInstance(carClass.getClassLoader(), new Class<?>[]{carClass}, new ProxyFactory<>(carClass));
    }

    private static class ProxyFactory<T> implements InvocationHandler {
        private Class<T> clazz;

        public ProxyFactory (Class<T> tClass) {
            this.clazz = tClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 1.封装message content
            MyContent content = new MyContent().setArgs(args).setInterfaceName(clazz.getName()).setMethodName(method.getName())
                    .setParameterTypes(method.getParameterTypes());

            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(content);
            byte[] contentArr = arrayOutputStream.toByteArray();

            System.out.println("content length: " + contentArr.length);

            // 2. message header
            MyHeader header = new MyHeader().setDataLength(contentArr.length).setRequestId(Math.abs(UUID.randomUUID().getLeastSignificantBits()))
                    .setFlag(0x11111111);

            arrayOutputStream.reset();
            objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(header);
            byte[] headArr = arrayOutputStream.toByteArray();

            System.out.println("header length: " + headArr.length);

            // 3，连接池
            ClientFactory factory = ClientFactory.getFactory();
            NioSocketChannel channel = factory.getChannel(new InetSocketAddress("127.0.0.1", 8888), 10);
            // 4，发送
            ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(headArr.length + contentArr.length);

            long id = header.getRequestId();
            CompletableFuture<String> res = new CompletableFuture<>();
            ResponseCallBack.addCallBack(id, res);

            byteBuf.writeBytes(headArr);
            byteBuf.writeBytes(contentArr);

            ChannelFuture channelFuture = channel.writeAndFlush(byteBuf);
            channelFuture.sync().get();

            return res.get();
        }
    }

}
