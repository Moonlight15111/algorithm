package com.moonlight.algorithm.io.rpc.v1.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName MyContent
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 20:45
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class MyContent implements Serializable {
    private String methodName;
    private Object[] args;
    private String interfaceName;
    private Class<?>[] parameterTypes;
    private String res;
}
