package com.moonlight.algorithm.train.recursion;

import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 汉诺塔
 * @author Moonlight
 * @date 2021/1/15 11:57
 */
public class Hanota {

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        process(A.size(), A, B, C);
    }

    public static void process(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 看做两个部分，第一部分就是最上面的第n个盘子，第二部分就是从n - 1到1个盘子
        // 对于两个盘子X, Y，处理逻辑：X:A -> B  Y: A -> C  X: B -> C
        process(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        process(n - 1, B, A, C);
    }
}
