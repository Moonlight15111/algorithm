package com.moonlight.algorithm.io.rpc.v1.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName Msg
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 21:53
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class Msg implements Serializable {
    private MyHeader header;
    private MyContent content;
}
