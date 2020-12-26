package com.moonlight.algorithm.train.sort;

/**
 * @ClassName NetherlandsFlag
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/26 18:32
 * @Version V1.0
 **/
public class NetherlandsFlag {

    // arr[L...R] 排有序，快排2.0方式
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }

    public static int[] netherlandsFlag(int[] arr, int left, int right) {
        if (left > right) {
            return new int[] { -1, -1 };
        }
        if (left == right) {
            return new int[] {left, right};
        }
        // 小于区右边界
        int less = left - 1;
        // 大于区左边界
        int more = right;
        int index = left;
        while (index < more) {
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        // <[R]   =[R]   >[R]
        swap(arr, more, right);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
