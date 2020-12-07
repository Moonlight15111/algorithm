package com.moonlight.algorithm.io.endian;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/7 18:14
 */
public class Test {

    public static int bytes2Int(byte[] bytes) {
        int num = bytes[3] & 0xFF;
        num |= (bytes[2] << 8) & 0xFF00;
        num |= (bytes[1] << 16) & 0xFF0000;
        num |= (bytes[0] << 24) & 0xFF000000;
        return num;
    }

    public static byte[] int2Bytes(int num) {
        byte[] res = new byte[4];
        res[0] = (byte)((num >> 24) & 0xFF);
        res[1] = (byte)((num >> 16) & 0xFF);
        res[2] = (byte)((num >> 8) & 0xFF);
        res[3] = (byte)((num) & 0xFF);
        return res;
    }

}
