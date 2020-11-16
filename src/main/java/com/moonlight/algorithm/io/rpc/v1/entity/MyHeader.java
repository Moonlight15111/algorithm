package com.moonlight.algorithm.io.rpc.v1.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName MyHeader
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 20:48
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class MyHeader implements Serializable {
    private long requestId;
    private long dataLength;
    private int flag;
}