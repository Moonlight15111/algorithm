package com.moonlight.algorithm.sort;

import com.moonlight.algorithm.Const;

/**
 * @ClassName CountingSort
 * @Description: 计数排序。
 * @Author Moonlight
 * @Date 2020/5/4 2:36
 * @Version V1.0
 **/
public class CountingSort implements Sort {

    public static void main(String[] arg){
        CountingSort sort = new CountingSort(new int[15]);
//        sort.sort(Const.arr);
//        Const.print(Const.arr);
        Const.print(sort.sort(Const.arr, sort.help));
    }

    private int[] help;

    public CountingSort(int[] help){
        this.help = help;
    }

    /**
     * @Author Moonlight
     * @Description 准备一个等长的help数组，循环arr中的数字，在help数组对应下标的位置进行 + 1 操作，
     *              如：arr中有两个0，那么help中下标为0的位置值就为2。遍历help数组，对应下标的值为多少，就在arr中加多少个对应下标的数
     * @Date 2020/5/5 23:33
     * @Param
     * @Exception
     * @return
     * @version
     **/
    @Override
    public void sort(int[] arr) {
        // 不稳定
        for (int value : arr) {
            this.help[value] += 1;
        }
        int j = 0;
        for (int i = 0, length = this.help.length; i < length; i++) {
            int count = this.help[i];
            while (count > 0) {
                arr[j++] = i;
                count--;
            }
        }
    }

    /**
     * @Author Moonlight
     * @Description 准备一个等长的help数组，一个等长的result数组，循环arr中的数字，在help数组对应下标的位置进行 + 1 操作，
     *              然后将help数组中的数进行累加 i位置 = i + (i - 1)。此时help数组中记录的就是对应数据最后出现的位置。
     *              将arr从右往左遍历，将对应数据写入到result数组的对应位置上（位置已经在help中记录了）
     * @Date 2020/5/5 23:37
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public int[] sort(int[] arr, int[] help) {
        int[] result = new int[arr.length];
        // 稳定
        for (int value : arr) {
            help[value] += 1;
        }
        for (int i = 1, length = help.length; i < length; i++) {
            help[i] = help[i] + help[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (help[arr[i]] > 0) {
                result[--help[arr[i]]] = arr[i];
            }
        }
        return result;
    }
}
