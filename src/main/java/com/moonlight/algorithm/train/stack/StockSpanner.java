package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/online-stock-span/
 *
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 * @author Moonlight
 * @date 2022-04-29 10:14
 */
public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(80));
    }

//    private List<Integer> list = new ArrayList<>();
    private Stack<Integer> priceStack = new Stack<>(), weightStack = new Stack<>();

    public StockSpanner() { }

    public int next(int price) {
        int weight = 1;
        while (!priceStack.isEmpty() && priceStack.peek() <= price) {
            priceStack.pop();
            weight += weightStack.pop();
        }
        priceStack.add(price);
        weightStack.add(weight);
        return weight;
//        int res = 1;
//        if (list.size() == 0) {
//            list.add(price);
//            return res;
//        }
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (list.get(i) > price) {
//                break;
//            }
//            res++;
//        }
//        list.add(price);
//        return res;
    }

}