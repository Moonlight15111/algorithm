package com.moonlight.algorithm.jvm;

/**
 * @ClassName RecursionMethodFrames
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/20 21:58
 * @Version V1.0
 **/
public class RecursionMethodFrames {

    public static void main (String[] args) {
        RecursionMethodFrames frames = new RecursionMethodFrames();
        frames.m(5);
    }

    public int m(int n){
//        0 iload_1 // 将参数 n 压入操作数栈
//        1 iconst_1 // 将常量 1 压入操作数栈
//        2 if_icmpne 7 (+5) // 如果 n 和 1 不相等，则跳转到第7条指令（question: 此处存疑，尚不确定jClassLib中前面这个编号是不是指的第几条指令.个人理解是跳到第7条指令。）
//        5 iload_1 // 如果 n == 1，则将参数n压入操作数栈
//        6 ireturn // 返回
//        7 iload_1 // 将参数n从局部变量表压入操作数栈, 这个n作为乘法的被乘数
//        8 aload_0 // 将this从局部变量表压入操作数栈, 这个this用于调用m方法
//        9 iload_1 // 再将参数n从局部变量表压入操作数栈, 这个n将与1进行减法运算
//        10 iconst_1 // 将常量 1 压入操作数栈
//        11 isub // n - 1
//        12 invokevirtual #4 <com/moonlight/algorithm/jvm/RecursionMethodFrames.m> // this调用m方法
//        15 imul // n 乘以 m方法的返回值
//        16 ireturn
        if (n == 1) {
            return n;
        }
        return n * m(n - 1);
    }

}
