package com.moonlight.algorithm.train.design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/online-election/
 *
 * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * 实现 TopVotedCandidate 类：
 *    TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
 *    int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 *
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 *
 *
 * @ClassName TopVotedCandidate
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/11 11:15
 * @Version V1.0
 **/
public class TopVotedCandidate {

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
        System.out.println(topVotedCandidate.q(3));
        // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
        System.out.println(topVotedCandidate.q(12));
        // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
        System.out.println(topVotedCandidate.q(25));
        // 返回 0
        System.out.println(topVotedCandidate.q(15));
        // 返回 0
        System.out.println(topVotedCandidate.q(24));
        // 返回 1
        System.out.println(topVotedCandidate.q(8));
    }

    private int[] times, cnt;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;

        int len = times.length, c = -1;
        this.cnt = new int[len];
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[persons[i]]++;
            if (c == -1 || temp[persons[i]] >= temp[c]) {
                c = persons[i];
            }
            cnt[i] = c;
        }
    }

    public int q(int t) {
        int left = 0, right = times.length, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (times[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return cnt[left - 1];
    }

}
