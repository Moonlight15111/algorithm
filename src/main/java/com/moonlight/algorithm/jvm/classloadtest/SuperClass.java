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
        System.out.println("super class init...");
    }
    public static int val = 1;
}
