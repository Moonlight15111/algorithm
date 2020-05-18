package com.moonlight.algorithm;


import com.moonlight.agent.Agent;

/**
 * @ClassName ObjectSizeTest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/18 23:08
 * @Version V1.0
 **/
public class ObjectSizeTest {
    public static void main(String[] args) {
        // -XX:+UseCompressedClassPointers  class pointer 指针压缩默认开启
        // -XX:+UseCompressedOops 普通对象（可以认为是引用）指针压缩默认开启
        // Oops: ordinary object pointers 普通对象指针

        System.out.println(Agent.sizeOf(new Object())); // 8字节 mark word 4字节 class pointer（开启指针压缩）4字节填充
        System.out.println(Agent.sizeOf(new int[] {})); // 8字节 mark word 4字节 class pointer（开启指针压缩）4字节数组长度
        System.out.println(Agent.sizeOf(new O()));
    }

    private static class O {
                        //8字节 mark word
                        //4字节 class pointer（开启指针压缩）
        int id;         //4字节
        String name;    //4字节（开启普通对象指针压缩）
        int age;        //4字节
        byte b1;        //1字节
        byte b2;        //1字节
        Object o;       //4字节（开启普通对象指针压缩）
        byte b3;        //1字节
                        //27字节 + 5字节填充 = 32字节
    }
}