package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 输入：s = "25525511135"  输出：["255.255.11.135","255.255.111.35"]
 *
 * 输入：s = "0000"  输出：["0.0.0.0"]
 *
 * 输入：s = "1111"  输出：["1.1.1.1"]
 *
 * 输入：s = "010010"  输出：["0.10.0.10","0.100.1.0"]
 *
 * 输入：s = "101023"  输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * @ClassName RestoreIpAddresses
 * @Description: TODO
 * @Author Moonlight阿三大苏打
 * @Date 2021/3/13 14:37
 * @Version V1.0
 **/
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("101023"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrack(0, 0, s, res);
        return res;
    }

    private static void backtrack(int start, int pointNum, String s, List<String> res) {
        if (pointNum == 3) {
            if (isIpAddr(s, start, s.length() - 1)) {
                res.add(s);
            }
        }
        for (int i = start, len = s.length(); i < len; i++) {
            if (isIpAddr(s, start, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtrack(i + 2, pointNum, s, res);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }
    }

    public static boolean isIpAddr(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            } else {
                return false;
            }
        }
        return num >= 0 && num <= 255;
    }



}