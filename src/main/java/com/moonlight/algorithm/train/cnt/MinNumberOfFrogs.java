package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking/
 *
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
 * 由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * 如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 * 输入：croakOfFrogs = "croakcroak"  输出：1
 * 解释：一只青蛙 “呱呱” 两次
 *
 * 输入：croakOfFrogs = "crcoakroak"  输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 *
 * 输入：croakOfFrogs = "croakcrook"  输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 *
 * 输入：croakOfFrogs = "croakcroa"  输出：-1
 *
 * @ClassName MinNumberOfFrogs
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/13 16:32
 * @Version V1.0
 **/
public class MinNumberOfFrogs {

    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("croakcrook"));
        System.out.println(minNumberOfFrogs("croakcroa"));
    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, ans = 0;
        char[] chars = croakOfFrogs.toCharArray();
        for (char f : chars) {
            if (f == 'c') {
                if (k > 0) {
                    k--;
                } else {
                    ans++;
                }
                c++;
            } else if (f == 'r') {
                r++;
                c--;
            } else if (f == 'o') {
                o++;
                r--;
            } else if (f == 'a') {
                a++;
                o--;
            } else if (f == 'k') {
                k++;
                a--;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0 || k < 0) {
                break;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return ans;
    }

}
