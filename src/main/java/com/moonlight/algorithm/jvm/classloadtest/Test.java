package com.moonlight.algorithm.jvm.classloadtest;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/5/28 14:38
 */
public class Test {
    public static void main (String[] args) {
        SubClass subClass = new SubClass();
        System.out.println("==============================");
        // 通过子类引用父类的静态变量并不会导致子类的初始化
        // 对于静态变量的引用只有直接定义了该字段的类才会被初始化
        System.out.println(SubClass.val);
        // 定义引用类的数组也不会触发它的初始化
        SubClass[] subClassArray = new SubClass[10];
        // 常量在编译阶段会被直接存入到调用类的常量池，本质上没有直接引用到定义该常量的类，因此不会触发定义该常量的类的初始化
        // 在编译阶段通过常量传播优化，将该常量的值存到了Test类的常量池中，后续Test对该常量的引用实际上会被转化为对自身常量池的引用
        // 也就是说，在编译后，SubClass和Test两个Class文件是没有任何联系的，Test.class中并不会有SubClass.class的符号引用
        System.out.println(SubClass.HELLOWORLD);
    }
}
