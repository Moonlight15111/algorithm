package com.moonlight.algorithm.spi.javaspi;

import java.util.ServiceLoader;

/**
 * java spi 实验测试类
 *
 * SPI（Service Provider Interface）是JDK内置的一种服务提供发现机制。
 * 本质是将接口实现类的全限定名配置在文件中，并由服务加载器读取配置文件，
 * 加载实现类。这样可以在运行时，动态为接口替换实现类。
 * 在Java中SPI是被用来设计给服务提供商做插件使用的。
 * 基于策略模式来实现动态加载的机制。我们在程序只定义一个接口，
 * 具体的实现交个不同的服务提供者；在程序启动的时候，读取配置文件，
 * 由配置确定要调用哪一个实现。有很多组件的实现，
 * 如日志、数据库访问等都是采用这样的方式，最常用的就是 JDBC 驱动。
 * SpringBoot自动注入也是基于此原理
 *
 * jdk 原生的 spi 机制:
 *   1. 不能按需加载。Java SPI在加载扩展点的时候，会一次性加载所有可用的扩展点，很多是不需要的，会浪费系统资源
 *   2. 获取某个实现类的方式不够灵活，只能通过 Iterator 形式获取，不能根据某个参数来获取对应的实现类
 *   3. 不支持AOP与IOC
 *   4. 如果扩展点加载失败，会导致调用方报错，导致追踪问题很困难
 *
 * @author Moonlight
 */
public class JavaSpiTest {

    public static void main(String[] args) {
        ServiceLoader<Human> load = ServiceLoader.load(Human.class);
        load.forEach(Human::doSomething);
    }

}