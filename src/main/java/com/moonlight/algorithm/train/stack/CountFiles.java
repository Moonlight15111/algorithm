package com.moonlight.algorithm.train.stack;

import java.io.File;
import java.util.Stack;

/**
 * 给定一个文件目录的路径，
 * 写一个函数统计这个目录下所有的文件数量并返回
 * 隐藏文件也算，但是文件夹不算
 *
 * @ClassName CountFiles
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/20 20:33
 * @Version V1.0
 **/
public class CountFiles {

    public static void main(String[] args) {
        System.out.println(countFiles("D:\\materials"));
    }

    public static int countFiles(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return 0;
        }
        File file = new File(filePath);
        if (!file.isDirectory() && !file.isFile()) {
            return 0;
        }
        if (file.isFile()) {
            return 1;
        }
        Stack<File> files = new Stack<>();
        files.push(file);
        File folder;
        int ans = 0;
        while (!files.isEmpty()) {
            folder = files.pop();
            for (File next : folder.listFiles()) {
                if (next.isFile()) {
                    ans++;
                } else if (next.isDirectory()) {
                    files.push(next);
                }
            }
        }
        return ans;
    }

}
