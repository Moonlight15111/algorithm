package com.moonlight.algorithm.spi.dubbospi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * dubbo spi 实验
 *
 * @author Moonlight
 */
public class DubboSpiTest {
    public static void main(String[] args) {
        ExtensionLoader<Pets> extensionLoader = ExtensionLoader.getExtensionLoader(Pets.class);
        Pets cat = extensionLoader.getExtension("cat");
        cat.howl();

        Pets dog = extensionLoader.getExtension("dog");
        dog.howl();
    }
}
