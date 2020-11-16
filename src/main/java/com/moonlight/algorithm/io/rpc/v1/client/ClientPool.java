package com.moonlight.algorithm.io.rpc.v1.client;

import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Getter;

/**
 * @ClassName ClientPool
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 21:22
 * @Version V1.0
 **/
public class ClientPool {

    @Getter
    private NioSocketChannel[] clients;
    @Getter
    private Object[] locks;

    ClientPool(int size) {
        clients = new NioSocketChannel[size];
        locks = new Object[size];
        for(int i = 0;i< size;i++){
            locks[i] = new Object();
        }
    }

}
