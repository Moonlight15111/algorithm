package com.moonlight.algorithm.spi.dubbospi;

import org.apache.dubbo.common.extension.SPI;

/**
 * dubbo spi 实验
 *
 * @author Moonlight
 */
@SPI
public interface Pets {

    void howl();

}
