package com.moonlight.algorithm.greedy;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 *  每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 g，这是能让孩子们满足胃口的饼干的最小尺寸；
 *  并且每块饼干 j ，都有一个尺寸 s 。如果 s >= g ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 *  你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *  输入: [1,2,3], [1,1]
 *  输出: 1
 *  解释:  你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 *         虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 *         所以你应该输出1。
 *  思路：应该用尽量小的饼干，去满足胃口小的孩子，
 *        最好做到胃口为 1 的孩子用尺寸为 1 的饼干满足
 *        胃口为 2 的孩子用尺寸为 2 的饼干满足,这样才能满足最多的孩子
 *
 * @author Moonlight
 * @date 2020/5/16 17:26
 */
public class DeliverCookies {

    public static void main (String[] args) {
        int[] childrenArr = {1,2,3}, cookieArr = {1, 1, 2};
        System.out.println(findContentChildren(childrenArr, cookieArr));
    }

    public static int findContentChildren (int[] childrenArr, int[] cookieArr) {
        if (childrenArr == null || childrenArr.length <= 0 || cookieArr == null || cookieArr.length <= 0) {
            return 0;
        }
        Arrays.sort(childrenArr);
        Arrays.sort(cookieArr);

        int children = 0, cookie = 0, childrenLength = childrenArr.length, cookieLength = cookieArr.length;

        while (children < childrenLength && cookie < childrenLength) {
            if (cookieArr[cookie] >= childrenArr[children]) {
                children++;
            }
            cookie++;
        }
        return children;
    }

}
