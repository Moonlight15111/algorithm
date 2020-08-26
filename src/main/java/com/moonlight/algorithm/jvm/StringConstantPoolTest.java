package com.moonlight.algorithm.jvm;

import java.lang.reflect.Field;

/**
 * @ClassName StringConstantPoolTest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/8/26 23:38
 * @Version V1.0
 **/
public class StringConstantPoolTest {

    public static void main ( String[] args) throws Exception {
        String s1 = "hello", s2 = new String("hello"), s3 = "world", s4 = "hello";

        System.out.println(s1 == s2); // false s1指向常量池,s2指向堆的对象,堆的对象再指向常量池
        System.out.println(s1 == s3); // false 字面量都不同
        System.out.println(s1 == s4); // true  同为字面量,即指向常量池的同一地址

        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        char[] charArray = "world".toCharArray();
        value.set(s1, charArray);

        System.out.println(s1); // world
        System.out.println(s4); // world
        System.out.println("hello"); // world

        // 在编译期,hello被解析到常量池,所以"hello"/s1/s4都是指向同一常量池位置
        // 但在运行期,通过反射对s1的value即常量池中这个地址的内容进行了篡改改成了world

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // true
    }

}
