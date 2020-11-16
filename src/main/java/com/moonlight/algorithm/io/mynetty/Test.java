package com.moonlight.algorithm.io.mynetty;

import com.moonlight.algorithm.io.mynetty.SelectorThreadGroup;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/9 22:35
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        SelectorThreadGroup boss = new SelectorThreadGroup(2);
        SelectorThreadGroup worker = new SelectorThreadGroup(3);

        boss.setWorker(worker);
        boss.bind(8888);
        boss.bind(9999);
    }
}
