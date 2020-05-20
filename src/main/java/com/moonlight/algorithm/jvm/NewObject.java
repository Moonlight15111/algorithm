package com.moonlight.algorithm.jvm;

/**
 * @ClassName NewObject
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/19 23:34
 * @Version V1.0
 **/
public class NewObject {

    public static void main(String[] args){
//        0 new #2 <com/moonlight/algorithm/jvm/NewObject> // 申请内存，创建一个只有默认值的对象，将其地址压入操作数栈
//        3 dup // duplicate 复制操作数栈顶值，并将其压入栈顶，也就是说此时操作数栈上有连续相同的两个对象地址
        // 因为VMS是基于栈的实现，任何操作都是入栈出栈，没有任何寄存器，所以如果要对某一操作数做两次连续操作，那就要复制两次栈顶操作数
        // new指令在堆上分配了内存，并在栈顶压入了指向这段内存的地址，来供任何下面的操作来调用，但是在这个内存地址赋值给我们的引用之前，
        // 虚拟机自己是要调用对象的 <init> 方法对其进行初始化的,这个操作会弹栈消耗掉一个操作数。也就是说，new一个对象，
        // 其实要连续两次对栈顶的操作数进行操作。其中一次是虚拟机调用<init>方法，另一次就是将操作数赋值给对象引用。
        // 其实类似与 int a; int b = a = 2; 这种语句也是会对 2 进行dup操作，因为它要连续两次store给变量a和b
//        4 invokespecial #3 <com/moonlight/algorithm/jvm/NewObject.<init>> // 调用构造方法，成员变量赋初始值，执行构造语句
//        7 astore_1 // 返回内存地址给引用
        NewObject object = new NewObject();
//        8 aload_1 // 引用压栈
//        9 invokevirtual #4 <com/moonlight/algorithm/jvm/NewObject.m> // 调用m方法，生成m的栈帧，只有当m方法结束后，才会从这里继续往下执行main方法
        object.m();
//        aload_1 // 引用压入操作数栈
//        invokevirtual #5 <com/moonlight/algorithm/jvm/NewObject.m1> // 调用m1方法
//        pop // 将栈顶数值弹出,即将m1方法的返回值弹出(因为m1方法结束后，会在main方法的栈顶上压入它的返回值，为了不妨碍下面的操作执行，所以不管有没有用都会将该返回值弹出)
        object.m1();
//        aload_1  // 引用压入操作数栈
//        invokevirtual #5 <com/moonlight/algorithm/jvm/NewObject.m1> // 调用m1方法
//        istore_2 // 将m1方法的返回值扔到局部变量表赋给j
        int j = object.m1();
    }

    public void m(){
//        0 sipush 200
//        3 istore_1
//        4 return
        int i = 200;
    }

    public int m1(){
        return 200;
    }

}
