package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2021/2/26 14:39
 */
public class PartitionLabels {

    public static void main(String[] args) {
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        for (Integer n : list) {
            System.out.print(n + ", ");
        }
        System.out.println();
        List<Integer> adas = partitionLabels("abcdefg");
        for (Integer n : adas) {
            System.out.print(n + ", ");
        }
    }


    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        // 先缓存好所有字符最后出现的位置 然后双指针划区间
        Map<Character, Integer> map = new HashMap<>();

        int length = S.length(), leftPtr = 0, rightPtr = 0;
        for (int i = 0; i < length; i++) {
            map.put(S.charAt(i), i);
        }

        for (int i = 0; i < length; i++) {
            rightPtr = Math.max(rightPtr, map.get(S.charAt(i)));

            if (rightPtr == i) {
                res.add(rightPtr - leftPtr + 1);
                leftPtr = rightPtr + 1;
            }
        }

        return res;
    }

}
