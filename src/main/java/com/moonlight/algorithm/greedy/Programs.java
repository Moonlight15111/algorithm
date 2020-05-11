package com.moonlight.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Programs
 * @Description: 会议安排。一个会议室同时只能开一场会议，求一天内最多能安排多少次会议
 *               先对所有的会议按照结束时间进行排序，结束时间最早的放最前面，按照此顺序
 *               对会议进行遍历，如果会议的开始时间晚于当前时间点，那么就可以安排此会议
 *               同时将当前时间点设置为此会议的结束时间，如果下个会议开始时间晚于当前会议结束时间
 *               那么下个会议就可以被安排，直至遍历结束。
 *
 * @Author Moonlight
 * @Date 2020/5/11 22:14
 * @Version V1.0
 **/
public class Programs {

    private int start, end;

    public Programs (int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main (String[] args) {
        Programs[] arr = new Programs[]{new Programs(6, 8), new Programs(7, 9), new Programs(8, 10), new Programs(12, 23), new Programs(13, 16), new Programs(16, 19)};
        System.out.println(maxPrograms(arr, 0, new ProgramsComparator()));
    }

    public static int maxPrograms (Programs[] arr, int timeLine, Comparator<Programs> comparator) {
        Arrays.sort(arr, comparator);
        int result = 0;
        for (Programs programs : arr) {
            if (programs.start >= timeLine) {
                result++;
                timeLine = programs.end;
            }
        }
        return result;
    }

    static class ProgramsComparator implements Comparator<Programs> {
        @Override
        public int compare(Programs o1, Programs o2) {
            return o1.end - o2.end;
        }
    }
}
