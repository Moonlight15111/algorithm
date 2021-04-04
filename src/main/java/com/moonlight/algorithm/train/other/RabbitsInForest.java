package com.moonlight.algorithm.train.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/rabbits-in-forest/
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。返回森林中兔子的最少数量。
 *
 * 输入: answers = [1, 1, 2]   输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]  输出: 11
 *
 * 输入: answers = []  输出: 0
 *
 * @ClassName RabbitsInForest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/4 1:10
 * @Version V1.0
 **/
public class RabbitsInForest {

    public static void main(String[] args) {
        int[] a = {1, 1, 2}, b = {10, 10, 10}, c = {1, 0, 1, 0, 0}, d = {0, 0, 1, 1, 1};
        // 5
        System.out.println(numRabbits(a));
        // 11
        System.out.println(numRabbits(b));
        // 5
        System.out.println(numRabbits(c));
        // 6
        System.out.println(numRabbits(d));
    }

    public static int numRabbits(int[] answers) {
//        1.对于数组中不同的回答（即不同的数字）
//        如:[1,2,3]
//        第一只兔子回答1，说明它看到1个和自己不一样的，所以这种颜色共2个(包括它自己)
//        第二只兔子回答2，说明它看到2个和自己不一样的，所以这种颜色共3个(包括它自己)
//        第三只兔子回答3，说明它看到3个和自己不一样的，所以这种颜色共4个(包括它自己)
//        所以一共 2 + 3 + 4 = 9只兔子
//        2.对于数组中相同的回答（即相同的数字）
//        因为题目要求最少数量，只要我们可以认为兔子的回答一样的就可以是相同颜色(但并不一定都可以相同,有条件的)数量就会尽可能的少。
//        如:[10,10,10]
//        第一只兔子回答10，说明它看到10个和自己不一样的，所以这种颜色共11个(包括它自己)
//        第二只兔子也回答10，此时可以有2种假设：
//        1）如果你认为它和第一只兔子颜色不同，那么和第二只兔子的颜色相同的就又11个（包括它自己），
//        目前为止就有22只兔子了。
//        2）如果认为它和第一只兔子同色，从第一只兔子回答中得知第一种颜色有11只，第二只兔子与其同色，
//        所以它可以看到另外10只同色的兔子，因此它也回答10，逻辑成立。
//        那么目前为止兔子数量为11只，比假设1少，符合题意。那么第三只也一样可以认为同色，数量会最小。
//
//        那么是不是兔子的回答一样就可以认为同色呢？不一定
//        如:[3,3,3,3,3]
//        第一只兔子回答3，那么有4只这种颜色的,所以我们最多可以容纳4个回答3的兔子为同一颜色，若把第五只回答3的兔子也归为同色的，那就有5种这种颜色的兔子了，那它们看到的就不会是3而是4了，那么就矛盾了。
//        所以此情形最少是8只
        if (answers == null || answers.length == 0) {
            return 0;
        }
        Arrays.sort(answers);
        int res = 0;
        // key: 兔子的答案，val: 这个答案出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : answers) {
            if (map.isEmpty() || !map.containsKey(n) || map.get(n) == 0) {
                res += n + 1;
                map.put(n, map.getOrDefault(n, 0) + 1);
            } else if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            // 当回答出现的次数等于兔子回答 + 1时，表示这种颜色所能代表的兔子数量已经到达了上限
            // 需要重新用另一种颜色来代替这一批兔子
            if (map.get(n) == n + 1) {
                map.put(n, 0);
            }
        }
        return res;
    }

}
