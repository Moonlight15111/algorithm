package com.moonlight.algorithm.xor;

import java.util.Arrays;

/**
 * @ClassName FindOneOddNum
 * @Description: 异或運算練習。
 * @Author Moonlight
 * @Date 2020/5/2 18:59
 * @Version V1.0
 **/
public class FindOddNum {

    public static void main(String[] args) {
        int[] arr = new int[]{11, 11, 11, 23, 23, 24, 11, 1, 1, 9, 9};
        System.out.println(findOneOddTimesNum(arr));

        System.out.println(getFarRightNumOne(10));

        int[] arr2 = new int[]{11, 11, 11, 23, 23, 24, 11, 1, 1, 9, 9, 10};
        System.out.println(Arrays.toString(findTwoOddTimesNum(arr2)));

        System.out.println(bit1Count(5));
    }

    /**
     * @Author Moonlight
     * @Description 只有一個數出現了奇數次，其它數都出現了偶數次，求此數
     * @Date 2020/5/2 19:03
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static int findOneOddTimesNum(int[] arr) {
        int res = -1;
        if (arr == null) {
            return res;
        }
        res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }

    /**
     * @Author Moonlight
     * @Description 有兩個數出現了奇數次，其它數都出現了偶數次，求這兩個數
     * @Date 2020/5/2 19:10
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static int[] findTwoOddTimesNum(int[] arr) {
        int xor = -1;
        if (arr == null) {
            return null;
        }
        xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        // 此時xor為a ^ b，獲取它最右側的1可知a與b是此處值是不一樣的
        int farRightOne = getFarRightNumOne(xor);
        int num = 0;
        for (int value : arr) {
            // value & farRightOne 不爲0 説明value在對應的位置上有一個1，因爲其他數都出現了偶數次，那麽最終 ^ 到的結果必然是a 或者 b
            if ((value & farRightOne) != 0) {
                num ^= value;
            }
        }
        // a 與 b 在farRightOne的位置上值是不同的，所以 num ^ xor即可得到另一個數
        return new int[]{num, xor ^ num};
    }

    /**
     * @Author Moonlight
     * @Description 有兩個數出現了奇數次，其它數都出現了偶數次，求此數
     * @Date 2020/5/2 19:13
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static int getFarRightNumOne(int num) {
        return num & ((~num) + 1);
    }

    public static int bit1Count(int num) {
        int count = 0;
        while (num != 0) {
            int farRightOne = getFarRightNumOne(num);
            count++;
            num ^= farRightOne;
        }
        return count;
    }

}
