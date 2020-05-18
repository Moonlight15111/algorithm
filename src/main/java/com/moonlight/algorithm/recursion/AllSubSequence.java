package com.moonlight.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AllSubSquences
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/16 9:15
 * @Version V1.0
 **/
public class AllSubSequence {

    public static void main (String[] args) {
        String str = "abcd";
        List<String> list = findAllSubSequence(str);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> findAllSubSequence(String str){
        String path = "";
        List<String> subSequences = new ArrayList<>();
        findSub(str.toCharArray(), 0, path, subSequences);
        return subSequences;
    }

    private static void findSub(char[] toCharArray, int index, String path, List<String> subSequences) {
        if (index == toCharArray.length) {
            subSequences.add(path);
            return;
        }
        String append = path + toCharArray[index];
        findSub(toCharArray, index + 1, path, subSequences);
        findSub(toCharArray, index + 1, append, subSequences);
    }

}
