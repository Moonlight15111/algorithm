package com.moonlight.algorithm.train.recursion;

/**
 * 原题：https://leetcode-cn.com/problems/jump-game-iii/
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处
 * 注意，不管是什么情况下，你都无法跳到数组之外
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 * @ClassName JumpGameiii
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/3 14:59
 * @Version V1.0
 **/
public class JumpGameiii {

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(canReach(arr, 5));
        int[] arr22 = {3, 0, 2, 1, 2};
        System.out.println(canReach(arr22, 2));
    }

    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return process(arr, start, visited);
    }

    public static boolean process(int[] arr, int start, boolean[] visited) {
        // 两个方向：i + arr[i]   i - arr[i]
        // base case：跳出边界了     当前位置为0了     之前来过这个位置但是没有跳到为0的位置
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        return process(arr, start + arr[start], visited) || process(arr, start - arr[start], visited);
    }

}
