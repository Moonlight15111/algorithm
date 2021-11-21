package com.moonlight.algorithm.train.design;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/design-an-ordered-stream/
 *
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * 实现 OrderedStream 类：
 *   OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 *   String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 *     如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，
 *     并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 *     否则，返回一个空列表。
 *
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
 * os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
 * os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
 * os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 *
 * @ClassName OrderedStream
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/21 12:26
 * @Version V1.0
 **/
public class OrderedStream {

    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        // 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(3, "ccccc"));
        // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(1, "aaaaa"));
        // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(2, "bbbbb"));
        // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(5, "eeeee"));
        // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        System.out.println(os.insert(4, "ddddd"));
    }

    String[] strings;
    int ptr = 0;
    public OrderedStream(int n) {
        strings = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        strings[idKey - 1] = value;
        List<String> ans = new ArrayList<>();
        for (int i = ptr; i < strings.length; i++) {
            if (strings[i] == null) {
                break;
            } else {
                ptr++;
                ans.add(strings[i]);
            }
        }
        return ans;
    }

}
