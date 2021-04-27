package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5   输出：15
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3   输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 *
 * 输入：weights = [1,2,3,1,1], D = 4    输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *
 * @author Moonlight
 * @date 2021/4/26 13:01
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, b = {3, 2, 2, 4, 1, 4}, c = {1, 2, 3, 1, 1};
        // 15
        System.out.println(shipWithinDays(a, 5));
        // 6
        System.out.println(shipWithinDays(b, 3));
        // 3
        System.out.println(shipWithinDays(c, 4));
    }

    public static int shipWithinDays(int[] weights, int d) {
        // 在必须分 d 次操作、不能够调换货物顺序的情况下，最少用多少载重，可以全部解决掉 w 数组中的货物
        // 如果我一次只装一个货物，那么最少需要的载重应该就是 max( w )
        // 如果我合在一起装，比如所有的货物我一次全部装走，那么最少需要的载重就是 sum( w )
        // 所以最佳的载重应该在[max( w )， sum( w )]这个区间内
        int max = 0, sum = 0, mid, days;

        for (int w : weights) {
            max = Math.max(w, max);
            sum += w;
        }

        while (max < sum) {
            mid = max + ((sum - max) >> 1);
            days = countDays(weights, mid);
            if (days > d) {
                max = mid + 1;
            } else {
                sum = mid;
            }
        }

        return max;
    }

    private static int countDays(int[] weights, int mid) {
        // 算出在以 mid 载重时，需要多少天才能送完 w 数组的所有货物
        int daysCount = 1, curWeights = 0;
        for (int w : weights) {
            curWeights += w;
            // 超重了，就从这个地方开始重新算
            if (curWeights > mid) {
                daysCount++;
                curWeights = w;
            }
        }
        return daysCount;
    }

}
