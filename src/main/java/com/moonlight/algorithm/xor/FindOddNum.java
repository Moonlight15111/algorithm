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
//        int[] arr = new int[]{11, 11, 11, 23, 23, 24, 11, 1, 1, 9, 9};
//        System.out.println(findOneOddTimesNum(arr));
//
//        System.out.println(getFarRightNumOne(10));
//
//        int[] arr2 = new int[]{11, 11, 11, 23, 23, 24, 11, 1, 1, 9, 9, 10};
//        System.out.println(Arrays.toString(findTwoOddTimesNum(arr2)));

        int[] arr3 = new int[]{0, 1, 0, 1, 0, 1, 99, 77, 88, 77, 88, 77, 88};
        System.out.println(singleNumber(arr3));

//        System.out.println(bit1Count(5));
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
     * 功能描述: <br>
     * 〈给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。〉
     *
     * @param nums
     * @return
     * @since 1.0.0
     * @author Moonlight
     * @date 2020/6/10 16:12
     */
    public static int singleNumber(int[] nums) {
        int x = 0;
        for(int i : nums) {
            // x == a^b^c^...^x
            x ^= i;
        }
        // 获取到最右边的1，即这些数字最开始不同的地方
        int rightDiff = x & (-x), result = 0;
        for (int i : nums) {
            //
            if ((rightDiff & i) != 0) {
                result ^= i;
            }
        }
        return result;
    }

    /**
     * @Author Moonlight
     * @Description 获取最右边的1
     * @Date 2020/5/2 19:13
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static int getFarRightNumOne(int num) {
        // num & ((~num) + 1) 这个也可以
        return num & (-num);
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
