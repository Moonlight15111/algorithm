package com.moonlight.algorithm.io.endian;


/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/7 18:14
 */
public class Test {

    public static void main(String[] args) {
        String hexTest = "hex test sTr 12@";
        String hex = bytes2Hex(hexTest.getBytes());
        System.out.println(hex);
        System.out.println(new String(hex2Bytes(hex)));
    }

    public static int bytes2Int(byte[] bytes) {
        // 读  大小端转换
        int num = bytes[3] & 0xFF;
        num |= (bytes[2] << 8) & 0xFF00;
        num |= (bytes[1] << 16) & 0xFF0000;
        num |= (bytes[0] << 24) & 0xFF000000;
        return num;
    }

    public static byte[] int2Bytes(int num) {
        // 写  大小端转换
        byte[] res = new byte[4];
        res[0] = (byte)((num >> 24) & 0xFF);
        res[1] = (byte)((num >> 16) & 0xFF);
        res[2] = (byte)((num >> 8) & 0xFF);
        res[3] = (byte)((num) & 0xFF);
        return res;
    }

    public static String bytes2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean negative;
        int num;
        String temp;
        for (byte b : bytes) {
            negative = b < 0;
            num = Math.abs(b);
            if (negative) {
                num |= 0x80;
            }
            temp = Integer.toHexString(num & 0xff);
            stringBuilder.append(temp.length() == 1 ? "0" : temp.toLowerCase());
        }
        return stringBuilder.toString();
    }

    public static byte[] hex2Bytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        String sub;
        int num;
        boolean negative;
        byte b;
        for (int i = 0, length = hex.length(); i < length; i += 2) {
            sub = hex.substring(i, i + 2);
            num = Integer.parseInt(sub, 16);
            negative = num > 127;
            if (num == 128) {
                num = -128;
            } else if (negative) {
                num = 0 - (num & 0x7f);
            }
            b = (byte)num;
            bytes[i / 2] = b;
        }
        return bytes;
    }

}
