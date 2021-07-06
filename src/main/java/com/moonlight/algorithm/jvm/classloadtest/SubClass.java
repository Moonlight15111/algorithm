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
        System.out.println("4. sub class init!!!");
    }
    {
        System.out.println("5. sub class instance ");
    }
    public SubClass() {
        System.out.println("6. sub class construct ");
    }
    public static final String HELLOWORLD = "hello world";
}
