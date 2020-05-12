package com.moonlight.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName MaxProfit
 * @Description: 每个项目有成本，利润(扣除成本花费后能得到的钱)。现有初始资金 M，最多能做 K 个项目。
 *               每做完一个项目，都可以马上获得利润，支持你去做下一个项目，但只能串行的做项目，且每个项目只能做一次
 *               求完成 K 个项目后，你能得到的最大资金是多少。
 *               思路：根据项目成本建立小根堆，根据项目利润建立大根堆，每次从小根堆中获取当前能做的项目，扔到大根堆中
 *               然后从大根堆中获取项目做。即每次都做能力范围内利润最高的项目。
 * @Author Moonlight
 * @Date 2020/5/12 23:25
 * @Version V1.0
 **/
public class MaxProfit {

    public static void main (String[] args) {
        Project[] projects = {new Project(1, 3), new Project(1, 2), new Project(6, 7), new Project(6, 10)};
        System.out.println(maxProfits(projects, 1, 3));
    }

    public static int maxProfits (Project[] projects, int initMoney, int projectLimit) {
        PriorityQueue<Project> costsMinSortQueue = new PriorityQueue<>(new CostsComparator());
        PriorityQueue<Project> profitsMaxSortQueue = new PriorityQueue<>(new ProfitsComparator());

        costsMinSortQueue.addAll(Arrays.asList(projects));

        for (int i = 0; i < projectLimit; i++) {
            while (!costsMinSortQueue.isEmpty() && costsMinSortQueue.peek().costs <= initMoney) {
                profitsMaxSortQueue.add(costsMinSortQueue.poll());
            }
            // 这个地方其实可以直接return，因为如果profitsMaxSortQueue为空，则：要不是没有项目做或已经没有项目做，要不就是初始资金根本无法达到成本的最低要求
            if (profitsMaxSortQueue.isEmpty()) {
                return initMoney;
            }
            initMoney += profitsMaxSortQueue.poll().profits;
        }
        return initMoney;
    }

    static class Project {
        private int costs;
        private int profits;

        public Project (int costs, int profits) {
            this.costs = costs;
            this.profits = profits;
        }
    }

    static class CostsComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.costs - o2.costs;
        }
    }

    static class ProfitsComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.profits - o1.profits;
        }
    }

}
