package com.moonlight.algorithm.io.iomode;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2021/4/26 12:43
 */
public class Summary {
    /*
     * socket:
     *       1.端点：IP + 端口
     *       2.四元组：源IP +源端口 + 目标IP + 目标端口
     *
     * 同步: 调用者需要等待调用返回结果，才会进行下一步操作。
     * 异步: 调用者不需要等待调用返回结果，即可进行下一步操作，被调
     *       用者通常依靠事件、回调等机制来通知调用者结果
     * 比如: 发了微信消息给别人，然后别的什么也不干，就干等着别人回消息，这是同步的
     *       发了微信消息给别人以后就不管了，就追剧、刷微博去了，当别人回消息过来的时候，微信会弹个提示框出来，这就是异步
     * 所谓同步异步关注的是消息的通信机制
     *
     * 阻塞: 请求不能立即得到响应，结果返回之前，当前线程会被挂起，只有当这个请求得到结果了才会返回
     * 非阻塞: 在不能立刻得到结果之前，该调用不会阻塞当前线程
     * 阻塞非阻塞关注的时你在等这个调用结果的时候的一个状态
     *
     * 就像以前做饭一样:
     *   1.小时候用柴火煮饭，没什么经验，把握不了火候，所以就搬个凳子一直守着，看情况添柴、退柴，一直到饭煮好才走开    这个时候是同步阻塞的
     *   2.煮多了以后，有经验了，再煮饭的时候就没有像以前一样傻不拉几的守着了，去炒菜，忙其他时候的时候时不时过来检查一下， 这个时候是同步非阻塞的
     *   3.再后来有电饭煲了，饭煮好了它会放个小音乐什么的，所以我根据不用管了，只要听到这个音乐，我就知道饭好了，         这个时候是异步非阻塞的
     * 在这个例子中，阻塞和非阻塞是相对于我这个做饭的人来说的，我一直守着它，除非这个饭煮好了，不然我其他什么事也不干
     * 同步和异步是相对于我煮饭的工具、方式来说的，我用柴火煮，那就需要自己去关注火候情况，用电饭煲就只要等它煮好了，它播个音乐通知我就行了
     *
     * BIO:
     *    传统的同步阻塞的IO模型，数据的读取写入都阻塞在一个线程里面等待操作完成。这种模型
     *    1. 在活动连接数不是特别高的情况下，可以让每一个连接专注于自己的I/O并且编程模型简单，也不用过多考虑系统的过载、限流等问题。
     *    2. 还可以加上线程池来进行改善，线程池本身就是一个天然的漏斗，可以缓冲一些系统处理不了的连接或请求。
     *    在连接数不是很多(小于单机1000)的情况下比较适合。
     *    服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程去处理
     *    没处理完之前此线程不能做其他操作，严重依赖于线程
     *    BIO方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高
     *
     * NIO:
     *    一种同步非阻塞的IO模型，在jdk1.4以后引入的，提供Channel、Selector、Buffer等抽象，提供阻塞和非阻塞两种模式(只有FileChannel无法设置成非阻塞模式)。
     *    阻塞模式就和BIO差不多，比较简单，但是性能和可靠性不是很好，非阻塞模式，主要就是不会进行阻塞，会立刻返回结果给调用方
     *    accept()之后不管有没有人连接过来都立刻返回结果，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，
     *    多路复用器轮询到连接有IO请求时才启动一个线程进行处理
     *    NIO方式适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器
     *
     *    1. socket主要的读、写、注册和接收函数，在等待就绪阶段都是非阻塞的，真正的I/O操作是同步阻塞的
     *    2. 单线程轮询事件，没有线程切换，只是拼命的读、写、选择事件
     *
     * 多路复用: 多路指多个TCP连接(即socket或者channel），复用指复用一个或几个线程。
     *   遍历的过程只触发一次用户态内核态的切换，调用时把fds传递给内核，内核这次调用传过来的fds，遍历，查询状态
     *
     * select、poll: 每次都要重新、重复传递fds  每次被调用了后，都需要做一个全量FDS的遍历
     * epoll: 规避掉了遍历
     *
     * AIO：异步非阻塞的IO模型，基于事件和回调机制完成的，应用程序操作之后不会阻塞，会直接返回，当后台处理完成后，
     *      操作系统会通知相应的线程进行后续的操作。比如说:操作系统会将可读的流传入read方法的缓冲区，并通知应用程序；
     *      对于写操作而言，当操作系统将write方法传递的流写入完毕时，操作系统主动通知应用程序。
     *      即可以理解为，read/write方法都是异步的，完成后会主动调用回调函数通知相应的线程。
     *
     *      NIO虽然提供了非阻塞的方法，但是在处理IO的行为上还是同步的。
     *
     *      在JDK1.7在nio包下面引入了AsynchronousSocketChannel、AsynchronousServerSocketChannel、AsynchronousFileChannel、AsynchronousDatagramChannel
     *      四个异步操作通道
     *      AIO方式使用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，
     *      充分调用操作系统参与并发操作，编程比较复杂，JDK1.7之后开始支持。.
     */
}
