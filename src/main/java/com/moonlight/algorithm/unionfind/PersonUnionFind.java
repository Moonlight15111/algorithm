package com.moonlight.algorithm.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PersonUnionFind
 * @Description: Person有三个字段：idCardNum/email/mobile. 假设只要Person实例的任意一个字段相同，
 *               我们就可以认为这两个或多个Person实例都是指的同一人。如：
 *               Person A {idCardNum：1，email：2，mobile：3}
 *               Person B {idCardNum：1，email：4，mobile：5}
 *               Person C {idCardNum：9，email：8，mobile：3}
 *               因为 A.idCardNum == B.idCardNum 且 A.mobile == C.mobile 则A/B/C都是指的同一人
 *               给定一个Person数组，求数组中究竟有几个独立的人
 * @Author Moonlight
 * @Date 2020/5/13 23:16
 * @Version V1.0
 **/
public class PersonUnionFind {

    public static void main (String[] args) {
        Person[] persons = {new Person("1", "2", "3"),
                new Person("1", "4", "5"),
                new Person("9", "8", "3"),
                new Person("7", "7", "7"),
                new Person("6", "6", "7")};
        System.out.println(merge(persons));
    }

    static class Person {
        private String idCardNum;
        private String email;
        private String mobile;

        public Person(String idCardNum, String email, String mobile){
            this.idCardNum = idCardNum;
            this.email = email;
            this.mobile = mobile;
        }
    }

    public static int merge(Person[] persons){
        UnionFind.UnionSet<Person> personUnionSet = new UnionFind.UnionSet<>(persons);

        Map<String, Person> idCardNumMap = new HashMap<>();
        Map<String, Person> emailMap = new HashMap<>();
        Map<String, Person> mobileMap = new HashMap<>();

        for (Person person : persons) {
            if (idCardNumMap.containsKey(person.idCardNum)) {
                personUnionSet.union(person, idCardNumMap.get(person.idCardNum));
            } else {
                idCardNumMap.put(person.idCardNum, person);
            }

            if (emailMap.containsKey(person.email)) {
                personUnionSet.union(person, emailMap.get(person.email));
            } else {
                emailMap.put(person.email, person);
            }

            if (mobileMap.containsKey(person.mobile)) {
                personUnionSet.union(person, mobileMap.get(person.mobile));
            } else {
                mobileMap.put(person.mobile, person);
            }
        }

        return personUnionSet.getMetaSize();
    }

}
