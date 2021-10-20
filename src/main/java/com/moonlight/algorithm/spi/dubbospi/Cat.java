package com.moonlight.algorithm.spi.dubbospi;

/**
 * 功能描述:
 * <p>
 * 主要逻辑:
 * <p>
 * 注意事项:
 *
 * @author Moonlight<bzeng @ ibingli.com>
 * @date 2021-10-20 17:05
 */
public class Cat implements Pets {
    @Override
    public void howl() {
        System.out.println("猫叫: 喵喵喵喵 ... ");
    }
}
