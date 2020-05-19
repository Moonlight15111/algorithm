package com.moonlight.algorithm.jvm;

/**
 * @ClassName JvmStacks
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/19 22:52
 * @Version V1.0
 **/
public class JvmStacks {

    public static void main(String[] args){
        int i = 1;
        int z = 100;
        int zzz = 200;
        int max = Integer.MAX_VALUE;
        // 简单的解释
//        i = i++; // i = 1: temp = i(等号右边的i)  i = i + 1(等号右边的i)  i = temp(等号左边的i)
//        i = ++i; // i = 2: i = i + 1(等号右边的i) temp = i(等号右边的i) i = temp(等号左边的i)
//        int j = i++; // j = 1, i = 2 : temp = i   i = i + 1   j = temp
//        int k = i + ++i * i++; // k = 2 + 3 * 3 = 11, i = 4
//        System.out.println("i: " + i + "   j: " + j + "  k: " + k);
        // 字节码层次解释
//        0 iconst_0 // 当int取值-1~5时，JVM采用iconst指令将常量压入栈中,所以此指令是将0压入操作数栈
//        1 istore_1 // 将操作数栈栈顶元素弹出，保存到局部变量表下标为1的位置
        // 上面两句就是给 变量i 赋值
//        2 bipush 100 // 当int取值-128~127时，JVM采用bipush指令将常量压入栈中
//        4 istore_2 // 将100弹出，保存到局部变量表下标为2的位置
        // 给 变量z 赋值
//        5 sipush 200 // 当int取值-32768~32767时，JVM采用sipush指令将常量压入栈中。todo: 猜测这个s和short有关，但是没有找到相应的文档说明，oracle的官方docs网站目前进不去，后续待查验
//        8 istore_3 // 将200弹出，保存到局部变量表下标为3的位置
        // 给 变量zzz 赋值
//        9 ldc #3 <2147483647> // 当int取值-2147483648~2147483647时，JVM采用ldc指令将常量压入栈中。这个地方是从常量池中获取的，说明（-2147483648~2147483647）内的int值是存储在常量池中的
//        11 istore 4 // 将2147483647，保存到局部变量表下标为4的位置
        // 给 变量max 赋值

//        13 iload_1 // 从局部变量表读取下标为1的变量，压入操作数栈
//        14 iinc 1 by 1 // 将局部变量表中的变量i + 1,此时i = 2，question: 个人理解，操作应该都是基于操作数栈进行操作的，为什么++操作直接在局部变量表进行？也许是为了效率着想？
//        17 istore_1 // 将操作数栈栈顶元素弹出，保存到局部变量表下标为1的位置上，此时将覆盖i+1后的值，所以i还是为1

//        18 iinc 1 by 1 // 将局部变量表中的变量i + 1,此时i = 2
//        21 iload_1 // 将i压入操作数栈
//        22 istore_1 // 将i出栈，保存到局部变量表
        // 如上可见 i++ 与 ++i 操作区别就是先压栈还是先自增

//        23 getstatic #4 <java/lang/System.out>
//        26 iload_1
//        27 invokevirtual #5 <java/io/PrintStream.println>
//        30 return
        i = i++;
        i = ++i;
        System.out.println(i);
    }

    public void m1(){
//        0 bipush 100 // 压栈
//        2 istore_1 // 此处下标为1 是因为此方法不是static，所以局部变量表下标为0的位置保存了this，因为实例方法需要对象才能调用，这也是为什么实例方法中可以调用this的原因?
//        3 return
        int i = 100;
    }

    public void m2(int a, int b){
//        0 iload_1 // a压入栈
//        1 iload_2 // b压入栈
//        2 iadd // 加法操作，然后操作数a b 出栈，结果压入栈顶
//        3 istore_3 // 返回栈顶的结果
//        4 return
        int i = a + b;
    }

}
