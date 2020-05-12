package com.moonlight.algorithm.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName lightsUp
 * @Description: 一个字符串只有 X 和 . 组成，X 代表墙,不能放灯，也不能被点亮 . 代表一户人家，可以放灯，也可以被点亮
 *               如果灯放在第 i 个位置上，那么第 i - 1 个位置/第 i 个位置/第 i + 1 个位置就认为被点亮了
 *               求如果每户人家都需要被点亮，那么最少需要多少盏灯。
 *               暴力解法：每一个点都去尝试放灯与不放灯，将所有放灯的可能性罗列，然后找出那些所有位置都照亮的可能性，再在其中选出灯最少的
 *               贪心解法：如果第 i 个位置是 X 那么就可以直接跳过此位置，直接进入 i + 1 位置上
 *                         如果第 i 个位置是 . 那么就需要讨论第 i + 1 个位置是什么，如果第 i + 1 个位置是 X，那么就可以直接在 i + 1 位置上放灯
 *                         如果第 i + 1 位置是 . 那么就可以直接在 i + 1位置上放灯，无需在继续讨论下去，因为灯的范围只有 i - 1  i  i + 1 所以我们
 *                         可以说我们只需要在意 i - 1  i  i + 1 三个位置即可
 * @Author Moonlights
 * @Date 2020/5/11 22:45
 * @Version V1.0
 **/
public class LightUp {

    public static void main (String[] args) {
        String s = "XX...XX.X.X....XX."; // 6
        String s2 = "X.X.X..X...X.";

        System.out.println(minLights(s.toCharArray(), 0, new HashSet<>()));
        System.out.println(minLength(s.toCharArray()));

        System.out.println(minLights(s2.toCharArray(), 0, new HashSet<>()));
        System.out.println(minLength(s2.toCharArray()));
    }

    public static int minLength(char[] arr) {
        int index = 0, lights = 0, length = arr.length;

        while (index < length) {
            // 如果第 i 个位置是 X 那么就可以直接进入下个位置
            if (arr[index] == 'X') {
                index++;
                continue;
            }
            // 如果第 i 个位置是 . 无论如何都是会放置一盏灯的
            lights++;

            if (index + 1 == length) {
                break;
            }
            // 如果第 i + 1 个位置是 X，那么就可以直接进入到 i + 2 位置上
            if (arr[index + 1] == 'X') {
                index += 2;
            } else {
                // 如果第 i + 1 个位置是 . 那么此时灯应该放置在 i + 1 位置上，那么不管 i + 2 位置是什么，我们都可以直接跳过了
                index += 3;
            }
        }

        return lights;
    }

    public static int minLights (char[] arr, int index, Set<Integer> lights) {
        // base case
        if (index == arr.length) {
            for (int i = 0, length = arr.length; i < length; i++) {
                // 如果当前位置为 . 那么就去查询这个位置是否被照亮，如果没有被照亮，那么说明此时是一个无效解，返回Integer.MAX_VALUE
                if (arr[i] != 'X') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            // 当前位置不管是什么都是可以选择不放灯的，no 表示不放灯
            int no = minLights(arr, index + 1, lights);
            // yes表示放灯
            int yes = Integer.MAX_VALUE;
            if (arr[index] == '.') {
                lights.add(index);
                yes = minLights(arr, index + 1, lights);
                // 恢复现场，因为我们递归过程中始终是用的同一个lights
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

}
