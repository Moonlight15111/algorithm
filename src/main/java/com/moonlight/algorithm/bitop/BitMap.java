package com.moonlight.algorithm.bitop;

/**
 * @ClassName BitMap
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/27 15:08
 * @Version V1.0
 **/
public class BitMap {

    private long[] map;

    public BitMap(int max) {
        map = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        // num & 63 ==> num % 64   ==> 只适用于 num % 2的n次方
        map[(num >> 6)] |= (1L << (num & 63));
    }

    public void del(int num) {
        // num &  63 ==> num % 64
        map[(num >> 6)] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (map[num >> 6] & (1L << (num & 63))) != 0;
    }

}
