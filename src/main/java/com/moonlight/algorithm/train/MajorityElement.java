package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。〉
 *  原题：https://leetcode-cn.com/problems/majority-element/
 * @author Moonlight
 * @date 2020/6/11 15:59
 */
public class MajorityElement {

    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
        int[] arr2 = {5, 6, 5};
        System.out.println(majorityElement(arr2));
        int[] arr3 = {1, 2, 3};
        System.out.println(majorityElement(arr3));
        int[] arr4 = {2, 2, 1, 3, 2};
        System.out.println(majorityElement(arr4));
    }

    public static int majorityElement(int[] nums) {
        // 摩尔投票  多数元素与其他元素两两抵消后，还剩下的就肯定是多数元素
        int candidate = nums[0], count = 1;
        for (int num : nums) {
            // 如果当前这个数和候选人相等，那么就给候选人票数 + 1
            if (candidate == num) {
                count++;
                // 如果不相等，那么票数 - 1 如果票数为0了，那么就将候选人更换为当前数，并重置票数为 1
            } else if (--count == 0) {
                candidate = num;
                count = 1;
            }
        }
        if (count > 0) {
            count = 0;
            for (int n : nums) {
                if (n == candidate) {
                    count++;
                }
            }
            if (count > (nums.length / 2)) {
                return candidate;
            }
        }
        return -1;
    }
}
