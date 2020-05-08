package com.moonlight.algorithm.tree;

/**
 * @ClassName BinaryTreeOrigami
 * @Description: 折纸问题，一张纸对折一次会有一个凹痕，对折两次在原来的凹痕上方有一个新凹痕，下方有一个新凸痕
 * @Author Moonlight
 * @Date 2020/5/8 22:00
 * @Version V1.0
 **/
public class BinaryTreeOrigami {

    public static void main(String[] args){
        printFolds(2);
    }

    public static void printFolds(int foldTimes){
        printFolds(1, foldTimes, true);
    }

    private static void printFolds(int curFoldCount, int foldTimes, boolean down) {
        if (curFoldCount > foldTimes) {
            return;
        }
        printFolds(curFoldCount + 1, foldTimes, true);
        System.out.println(down ? "凹痕" : "凸痕");
        printFolds(curFoldCount + 1, foldTimes, false);
    }

}
