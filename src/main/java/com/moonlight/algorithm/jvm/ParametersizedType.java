package com.moonlight.algorithm.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/6/2 11:13
 */
public class ParametersizedType {

    // todo 这个地方编译不过很好理解，因为编译后泛型将会被擦除，导致两个方法签名一模一样
    // todo 从这个角度来看，java的泛型是伪泛型，只在源码中存在，编译后就会替换成原来的原生类型，并在相应的地方
    // todo 进行了自动强制转换，对于运行期代码，List<Integer>和List<String>是一样的
//    public void method(List<Integer> list){
//        System.out.println(" ret void param integer type list method ");
//    }
//
//    public void method(List<String> list){
//        System.out.println(" ret void param string type list method");
//    }

    // todo 这个地方在某些编译器上(SunJDK 1.6 javac 编译器)上是可以编译的，但在idea等IDE中会编译不过。
    // todo 编译能过是因为加了返回值，但不是因为加了返回值就能重载，而是说加了不同返回值后，这两个方法就能存在于同一
    // todo class文件中，在Class文件中只要描述符不是完全一致的两个方法就可以共存，即就算方法参数、名称这些都完全一致，
    // todo 但返回值不同，也可以合法共存
    // PS 在java代码中，方法的特征签名只包括方法名、参数顺序、参数类型，但在Class字节码中，还包括返回值、受查异常表
    // PS 两个字段的修饰符、数据类型不管一不一致，都不允许同名，但在class字节码中，只要两个字段的描述符（即修饰符、数据类型等）不完全一致
    // PS 那么字段重名就是合法的
//    public String method2(List<String> list){
//        System.out.println(" ret string param string type list method 2");
//        return "";
//    }
//
//    public int method2(List<Integer> list){
//        System.out.println(" ret string param string type list method 2");
//        return 0;
//    }

    public static void main(String[] args){
//        ParametersizedType test = new ParametersizedType();
//        test.method2(new ArrayList<String>());
//        test.method2(new ArrayList<Integer>());
        Integer a = 1, b = 2, c = 3, d = 3, e = 321, f = 321;
        Long g = 3L;
        // true
        System.out.println(c == d);
        // false
        System.out.println(e == f);
        // true
        System.out.println(c == (a + b));
        // true
        System.out.println(c.equals(a + b));
        // true
        System.out.println(g == (a + b));
        // false
        System.out.println(g.equals( a + b));
    }

}
