package com.moonlight.algorithm.train.greedy;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/25 9:21
 */
public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int children = 0, cookie = 0;

        while (children < g.length && cookie < s.length) {
            if (s[cookie] >= g[children]) {
                children++;
            }
            cookie++;
        }

        return children;
    }

}
