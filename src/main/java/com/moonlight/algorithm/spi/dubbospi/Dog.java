package com.moonlight.algorithm.spi.dubbospi;

/**
 * dubbo spi 实验
 *
 * @author Moonlight
 */
public class Dog implements Pets{
    @Override
    public void howl() {
        System.out.println("狗叫: 汪汪汪汪");
    }
}