package com.moonlight.algorithm.train.design;

/**
 *
 * 请你设计一个管理 n 个座位预约的系统，座位编号从 1 到 n 。
 * 请你实现 SeatManager 类：
 *   SeatManager(int n) 初始化一个 SeatManager 对象，它管理从 1 到 n 编号的 n 个座位。所有座位初始都是可预约的。
 *   int reserve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
 *   void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
 *
 * 输入：
 * ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
 * [[5], [], [], [2], [], [], [], [], [5]]
 * 输出：
 * [null, 1, 2, null, 2, 3, 4, 5, null]
 *
 * 解释：
 * SeatManager seatManager = new SeatManager(5); // 初始化 SeatManager ，有 5 个座位。
 * seatManager.reserve();    // 所有座位都可以预约，所以返回最小编号的座位，也就是 1 。
 * seatManager.reserve();    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
 * seatManager.unreserve(2); // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
 * seatManager.reserve();    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
 * seatManager.reserve();    // 可以预约的座位为 [3,4,5] ，返回最小编号的座位，也就是 3 。
 * seatManager.reserve();    // 可以预约的座位为 [4,5] ，返回最小编号的座位，也就是 4 。
 * seatManager.reserve();    // 唯一可以预约的是座位 5 ，所以返回 5 。
 * seatManager.unreserve(5); // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。
 *
 * @ClassName SeatManager
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 22:53
 * @Version V1.0
 **/
public class SeatManager {

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());    // 所有座位都可以预约，所以返回最小编号的座位，也就是 1 。
        System.out.println(seatManager.reserve());    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
        seatManager.unreserve(2); // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
        System.out.println(seatManager.reserve());;    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
        System.out.println(seatManager.reserve());;    // 可以预约的座位为 [3,4,5] ，返回最小编号的座位，也就是 3 。
        System.out.println(seatManager.reserve());;    // 可以预约的座位为 [4,5] ，返回最小编号的座位，也就是 4 。
        System.out.println(seatManager.reserve());;    // 唯一可以预约的是座位 5 ，所以返回 5 。
        seatManager.unreserve(5); // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。
    }

    private boolean[] seat;
    private int index;

    public SeatManager(int n) {
        seat = new boolean[n + 1];
        index = 1;
    }

    public int reserve() {
        if (index >= seat.length) {
            return -1;
        }
        int res = index;
        seat[index++] = true;
        while (index < seat.length && seat[index]) {
            index++;
        }
        return res;
    }

    public void unreserve(int seatNumber) {
        seat[seatNumber] = false;
        index = Math.min(index, seatNumber);
    }

}
