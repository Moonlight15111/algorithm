package com.moonlight.algorithm.train.sort;

/**
 * @ClassName BiggerThanRightTwice
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/26 12:41
 * @Version V1.0
 **/
public class BiggerThanRightTwice {

    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 20, 7};
        System.out.println(biggerThanRightTwice(arr));
    }

    public static int biggerThanRightTwice(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int res = 0;

        int windowR = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (windowR <= right && (arr[windowR] << 1) < arr[i]) {
                windowR++;
            }
            res += windowR - mid - 1;
        }

        int[] tmp = new int[right - left + 1];
        int leftP = left, rightP = mid + 1;
        int i = 0;
        while (leftP <= mid && rightP <= right) {
            tmp[i++] = arr[leftP] <= arr[rightP] ? arr[leftP++] : arr[rightP++];
        }

        while (leftP <= left) {
            tmp[i++] = arr[leftP++];
        }

        while (rightP <= right) {
            tmp[i++] = arr[rightP++];
        }

        for (i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }

        return res;
    }


}
