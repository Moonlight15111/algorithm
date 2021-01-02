package com.moonlight.algorithm.train.recursion;
import java.util.ArrayList;
import java.util.List;
/**
 * 打印一个字符串的所有子序列
 * 以String abc = "abc" 为例
 * 子串：a ab abc b bc c  即以字符串任何一个位置开头的情况下来枚举的
 * 子序列：a ab ac abc b bc c ""  即在原始字符串中从左往右拿字符，可以不连续，但是字符的相对位置不能变
 * @ClassName PrintAllSubSequence
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/2 12:41
 * @Version V1.0
 **/
public class PrintAllSubSequence {

    public static void main(String[] args) {
        String s = "abc";
        for (String ss : printAllSubSequence(s)) {
            System.out.println(ss);
        }
    }

    public static List<String> printAllSubSequence(String str) {
        List<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        if (str.length() == 0) {
            res.add("");
            return res;
        }
        char[] chars = str.toCharArray();
        String path = "";
        process(chars, 0, path, res);
        return res;
    }

    private static void process(char[] chars, int index, String path, List<String> res) {
        if (index == chars.length) {
            res.add(path);
            return;
        }
        // 选当前位置   不选当前位置
        process(chars, index + 1, path, res);
        String notSkip = path + chars[index];
        process(chars, index + 1, notSkip, res);
    }

}
