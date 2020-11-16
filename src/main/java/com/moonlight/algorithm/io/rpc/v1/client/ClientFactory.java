package com.moonlight.algorithm.io.rpc.v1.client;

import com.moonlight.algorithm.io.rpc.v1.handler.ClientResponses;
import com.moonlight.algorithm.io.rpc.v1.handler.ServerDecode;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ClientFacotry
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 21:14
 * @Version V1.0
 **/
public final class ClientFactory {

    private ClientFactory() {}

    private static final ClientFactory factory;

    static {
        factory = new ClientFactory();
    }

    public static ClientFactory getFactory(){
        return factory;
    }

    private Map<InetSocketAddress, ClientPool> poolMap = new ConcurrentHashMap<>();

    public synchronized NioSocketChannel getChannel(InetSocketAddress address, int poolSize) {
        ClientPool clientPool = poolMap.get(address);
        if(clientPool ==  null){
            poolMap.putIfAbsent(address,new ClientPool(poolSize));
            clientPool =  poolMap.get(address);
        }

        int i = new Random().nextInt(poolSize);

        if( clientPool.getClients()[i] != null && clientPool.getClients()[i].isActive()){
            return clientPool.getClients()[i];
        }

        synchronized (clientPool.getLocks()[i]){
            return clientPool.getClients()[i] = create(address);
        }
    }

    private NioSocketChannel create(InetSocketAddress address) {
        NioEventLoopGroup worker = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ServerDecode()).addLast(new ClientResponses());
                    }
                }).connect(address);
        try {
            return (NioSocketChannel) connect.sync().channel();
        } catch (InterruptedException e) {
            return null;
        }
    }

}
