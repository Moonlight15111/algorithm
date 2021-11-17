package com.moonlight.algorithm.train.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/throne-inheritance/
 *
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * 这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。
 * 请你实现 ThroneInheritance 类：
 *    ThroneInheritance(string kingName) 初始化一个 ThroneInheritance 类的对象。国王的名字作为构造函数的参数传入。
 *    void birth(string parentName, string childName) 表示 parentName 新拥有了一个名为 childName 的孩子。
 *    void death(string name) 表示名为 name 的人死亡。一个人的死亡不会影响 Successor 函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
 *    string[] getInheritanceOrder() 返回 除去 死亡人员的当前继承顺序列表。
 *
 * ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
 * t.birth("king", "andy"); // 继承顺序：king > andy
 * t.birth("king", "bob"); // 继承顺序：king > andy > bob
 * t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
 * t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
 * t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
 * t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
 * t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
 * t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
 * t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
 *
 * @author Moonlight
 */
public class ThroneInheritance {

    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king");
        // 继承顺序：king > andy
        t.birth("king", "andy");
        // 继承顺序：king > andy > bob
        t.birth("king", "bob");
        // 继承顺序：king > andy > bob > catherine
        t.birth("king", "catherine");
        // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("andy", "matthew");
        // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "alex");
        // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        t.birth("bob", "asha");
        // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        System.out.println(t.getInheritanceOrder());
        // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        t.death("bob");
        // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
        System.out.println(t.getInheritanceOrder());
    }

    Node root;
    Map<String, Node> map;

    public ThroneInheritance(String kingName) {
        root = new Node("");
        map = new HashMap<>();
        root.next = new Node(kingName);
        map.put(kingName, root.next);
    }

    public void birth(String parentName, String childName) {
        Node node = new Node(childName);
        map.put(childName, node);

        Node parent = map.get(parentName);

        Node lastChild = parent;
        while (lastChild.lastChild != null) {
            lastChild = lastChild.lastChild;
        }

        node.next = lastChild.next;
        lastChild.next = node;
        parent.lastChild = node;
    }

    public void death(String name) {
        map.get(name).isDeath = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        Node node = root.next;
        while (node != null) {
            if (!node.isDeath) {
                ans.add(node.name);
            }
            node = node.next;
        }
        return ans;
    }

    private static class Node {
        String name;
        Node lastChild;
        Node next;
        boolean isDeath;

        public Node(String name) {
            this.name = name;
            this.isDeath = false;
        }
    }

}
