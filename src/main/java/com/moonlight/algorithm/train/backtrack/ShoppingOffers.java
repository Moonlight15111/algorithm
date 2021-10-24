package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/shopping-offers/
 *
 *  LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。
 * 另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，
 * 且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。
 * 你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 * 输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
 * 输出：14
 * 解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。
 * 大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。
 * 大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。
 * 需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。
 *
 * 输入：price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
 * 输出：11
 * 解释：A ，B ，C 的价格分别为 ¥2 ，¥3 ，¥4 。
 * 可以用 ¥4 购买 1A 和 1B ，也可以用 ¥9 购买 2A ，2B 和 1C 。
 * 需要买 1A ，2B 和 1C ，所以付 ¥4 买 1A 和 1B（大礼包 1），以及 ¥3 购买 1B ， ¥4 购买 1C 。
 * 不可以购买超出待购清单的物品，尽管购买大礼包 2 更加便宜。
 *
 * @ClassName ShoppingOffers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/24 13:14
 * @Version V1.0
 **/
public class ShoppingOffers {

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(2);price.add(5);

        List<List<Integer>> special = new ArrayList<>();
        List<Integer> sa = new ArrayList<>(), sb = new ArrayList<>();
        sa.add(3);sa.add(0);sa.add(5); sb.add(1);sb.add(2);sb.add(10);
        special.add(sa);special.add(sb);

        List<Integer> needs = new ArrayList<>();
        needs.add(3);needs.add(2);

        System.out.println(shoppingOffers(price, special, needs));
    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 总思路：min(购买大礼包，不买大礼包)
        Map<List<Integer>, Integer> map = new HashMap<>();
        return backtrack(price, special, needs, map);
    }

    private static int backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int money = 0, goodsSize = price.size();
        // 不买大礼包
        for (int i = 0; i < goodsSize; i++) {
            money += price.get(i) * needs.get(i);
        }
        // 购买大礼包
        for (List<Integer> spec : special) {
            int specMoney = spec.get(goodsSize);
            List<Integer> restNeeds = new ArrayList<>();
            for (int i = 0; i < goodsSize; i++) {
                // 礼包中物品数量不能超过指定的数量
                if (spec.get(i) > needs.get(i)) {
                    break;
                }
                restNeeds.add(needs.get(i) - spec.get(i));
            }
            if (restNeeds.size() == goodsSize) {
                money = Math.min(money, backtrack(price, special, restNeeds, map) + specMoney);
            }
        }
        map.put(needs, money);
        return money;
    }

}