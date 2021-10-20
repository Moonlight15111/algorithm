package com.moonlight.algorithm.train.dp;

import java.util.*;

/**
 * 一只羊有7岁寿命，在3岁和5岁时,各产下1只小羊;
 * 一开始有1只羊,写出算法计算N年后有几只羊。
 */
public class Sheep {

    public static void main(String[] args) {
        System.out.println(nYears(7, new Sheep()));
        System.out.println(nYears(7));
    }

    private int age = 0;
    public Sheep newSheep() {
        if (age == 7) {
            return null;
        }
        age++;
        if (age == 3 || age == 5) {
            return new Sheep();
        }
        return null;
    }
    public static int nYears(int n, Sheep sheep) {
        Set<Sheep> set = new HashSet<>();
        set.add(sheep);
        for (int i = 0; i < n; i++) {
            List<Sheep> t = new ArrayList<>();
            set.forEach(s -> t.add(s.newSheep()));
            set.addAll(t);
            set.removeIf(Objects::isNull);
        }
        set.removeIf(s -> Objects.isNull(s) || s.age == 7);
        return set.size();
    }

    static int count = 1;
    public static int nYears(int n) {
        for (int i = 0; i <= n; i++) {
            if (i == 3 || i == 5) {
                count++;
                nYears(n - i);
            }
            if (i == 7) {
                count--;
                break;
            }
        }
        return count;
    }
}
