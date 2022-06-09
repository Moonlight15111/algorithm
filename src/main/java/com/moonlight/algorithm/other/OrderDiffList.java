package com.moonlight.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * <p>
 * 主要逻辑:
 * <p>
 * 注意事项:
 *
 * @author Moonlight
 */
public class OrderDiffList {

    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        ids.add("A");
        ids.add("B");
        ids.add("C");
        ids.add("D");
        List<Vo> vos = new ArrayList<>();
        vos.add(new Vo("B"));
        vos.add(new Vo("C"));
        vos.add(new Vo("D"));
        vos.add(new Vo("A"));
        vos.add(new Vo("E"));

        System.out.println("before sort: " + vos);

        sort(ids, vos);

        System.out.println("after sort: " + vos);
    }

    public static void sort(List<String> ids, List<Vo> vos) {
        int size = vos.size();
        vos.sort((a, b) -> {
            int aIdx = ids.indexOf(a.getId());
            int bIdx = ids.indexOf(b.getId());
            if (aIdx != -1) {
                aIdx = size - aIdx;
            }
            if (bIdx != -1) {
                bIdx = size - bIdx;
            }
            return bIdx - aIdx;
        });
    }

    static class Vo {
        private String id;

        public String getId() {
            return id;
        }

        public Vo(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Vo{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

}