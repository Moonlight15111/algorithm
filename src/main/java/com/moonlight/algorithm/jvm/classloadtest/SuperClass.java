package com.moonlight.algorithm.jvm.classloadtest;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/5/28 14:36
 */
public class SuperClass {
    static {
        System.out.println("1. super class init...");
    }
    {
        System.out.println("2. super class instance ");
    }
    public SuperClass() {
        System.out.println("3. Super class construct ");
    }
    public static int val = 1;
}
