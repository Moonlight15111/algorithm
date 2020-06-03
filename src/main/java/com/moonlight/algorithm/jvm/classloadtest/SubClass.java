package com.moonlight.algorithm.jvm.classloadtest;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/5/28 14:37
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("sub class init!!!");
    }
    public static final String HELLOWORLD = "hello world";
}
