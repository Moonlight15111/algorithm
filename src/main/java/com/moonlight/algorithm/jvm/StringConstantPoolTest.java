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

        // false s1指向常量池,s2指向堆对象
        System.out.println(s1 == s2);
        // false 字面量都不同
        System.out.println(s1 == s3);
        // true  同为字面量,即指向常量池的同一地址
        System.out.println(s1 == s4);

        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        char[] charArray = "world".toCharArray();
        value.set(s1, charArray);
        // world
        System.out.println(s1);
        // world
        System.out.println(s4);
        // world
        System.out.println("hello");
        // 上面都打印world的原因是因为
        // 在编译期,hello被解析到常量池,所以"hello"/s1/s4都是指向同一常量池位置
        // 但在运行期,通过反射对s1的value即常量池中这个地址的内容进行了篡改改成了world

        // false s1指向常量池,s2指向堆对象
        System.out.println(s1 == s2);
        // false
        System.out.println(s1 == s3);
        // true
        System.out.println(s1 == s4);

        String s = new String("123");
        String ss = new String("hello") + new String("world");
        // false 编译时 123 被解析到常量池，然后 s 指向堆对象，堆对象再指向常量池的 123
        // intern()后就相当于直接取了常量池的 123 的地址返回回来，所以两个地址是不一样的
        System.out.println(s.intern() == s);
        // true 编译时 hello 和 world 都被解析到了常量池，创建 ss 对象时，发现没有 helloworld 这个字符串
        // 于是就创建了这个字符串并扔到了常量池，ss直接就指向了常量池的这个 hellworld 字符串，
        // intern()返回的也是这个常量池的 helloworld 字符串的地址，所以是true
        System.out.println(ss.intern() == ss);
    }

}
