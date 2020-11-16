package com.moonlight.algorithm.io.rpc.v1.response;

import com.moonlight.algorithm.io.rpc.v1.entity.Msg;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ResponseCallBack
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 21:49
 * @Version V1.0
 **/
public class ResponseCallBack {

    private static Map<Long, CompletableFuture<String>> map = new ConcurrentHashMap<>();

    public static void addCallBack(Long requestId, CompletableFuture<String> cb) {
        map.putIfAbsent(requestId, cb);
    }

    public static void runCallBack(Msg msg){
        CompletableFuture<String> cf = map.get(msg.getHeader().getRequestId());
        cf.complete(msg.getContent().getRes());
        remove(msg.getHeader().getRequestId());
    }

    private static void remove(long requestId) {
        map.remove(requestId);
    }
}
