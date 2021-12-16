package com.moonlight.algorithm.train.trie;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/delete-duplicate-folders-in-system/
 *
 * 由于一个漏洞，文件系统中存在许多重复文件夹。给你一个二维数组 paths，
 * 其中 paths[i] 是一个表示文件系统中第 i 个文件夹的绝对路径的数组。
 * 例如，["one", "two", "three"] 表示路径 "/one/two/three" 。
 * 如果两个文件夹（不需要在同一层级）包含 非空且相同的 子文件夹 集合 并具有相同的子文件夹结构，
 * 则认为这两个文件夹是相同文件夹。相同文件夹的根层级 不 需要相同。如果存在两个（或两个以上）相同 文件夹，
 * 则需要将这些文件夹和所有它们的子文件夹 标记 为待删除。
 * 例如，下面文件结构中的文件夹 "/a" 和 "/b" 相同。它们（以及它们的子文件夹）应该被 全部 标记为待删除：
 * /a
 * /a/x
 * /a/x/y
 * /a/z
 * /b
 * /b/x
 * /b/x/y
 * /b/z
 * 然而，如果文件结构中还包含路径 "/b/w" ，那么文件夹 "/a" 和 "/b" 就不相同。
 * 注意，即便添加了新的文件夹 "/b/w" ，仍然认为 "/a/x" 和 "/b/x" 相同。
 * 一旦所有的相同文件夹和它们的子文件夹都被标记为待删除，文件系统将会 删除 所有上述文件夹。
 * 文件系统只会执行一次删除操作。执行完这一次删除操作后，不会删除新出现的相同文件夹。
 * 返回二维数组 ans ，该数组包含删除所有标记文件夹之后剩余文件夹的路径。路径可以按 任意顺序 返回。
 *
 * 输入：paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
 * 输出：[["d"],["d","a"]]
 *
 * 输入：paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
 * 输出：[["c"],["c","b"],["a"],["a","b"]]
 *
 * 输入：paths = [["a","b"],["c","d"],["c"],["a"]]
 * 输出：[["c"],["c","d"],["a"],["a","b"]]
 *
 * 输入：paths = [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"]]
 * 输出：[]
 *
 * 输入：paths = [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"],["b","w"]]
 * 输出：[["b"],["b","w"],["b","z"],["a"],["a","z"]]
 *
 * @author Moonlight
 */
public class DeleteDuplicateFolder {

    public static void main(String[] args) {
        List<List<String>> a = new ArrayList<>();
        a.add(Collections.singletonList("a"));
        a.add(Collections.singletonList("c"));
        a.add(Collections.singletonList("d"));
        a.add(Arrays.asList("a", "b"));
        a.add(Arrays.asList("c", "b"));
        a.add(Arrays.asList("d", "a"));

        List<List<String>> b = new ArrayList<>();
        b.add(Collections.singletonList("a"));
        b.add(Collections.singletonList("c"));
        b.add(Arrays.asList("a", "b"));
        b.add(Arrays.asList("c", "b"));
        b.add(Arrays.asList("a", "b", "x"));
        b.add(Arrays.asList("a", "b", "x", "y"));
        b.add(Collections.singletonList("w"));
        b.add(Arrays.asList("w", "y"));

        List<List<String>> folder = deleteDuplicateFolder(a);
        for (List<String> list : folder){
            System.out.print(list + ", ");
        }
        System.out.println();
        folder = deleteDuplicateFolder(b);
        for (List<String> list : folder){
            System.out.print(list + ", ");
        }
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        List<List<String>> ans = new ArrayList<>();
        Node root = new Node();

        buildTree(paths, root);
        deleteMark(root, new HashMap<>());
        dfs(root, new ArrayList<>(), ans);

        return ans;
    }

    private static void dfs(Node root, List<String> path, List<List<String>> ans) {
        for (Map.Entry<String, Node> entry : root.child.entrySet()) {
            if (entry.getValue().isDeleted) {
                continue;
            }
            path.add(entry.getKey());
            dfs(entry.getValue(), path, ans);
            path.remove(path.size() - 1);
        }
        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }
    }

    private static String deleteMark(Node root, Map<String, Node> delMap) {
        if (root.child.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Node> entry : root.child.entrySet()) {
            sb.append("\\").append(entry.getKey()).append(deleteMark(entry.getValue(), delMap)).append("\\");
        }
        String res = sb.toString();
        if (delMap.containsKey(res)) {
            delMap.get(res).isDeleted = true;
            root.isDeleted = true;
        } else {
            delMap.put(res, root);
        }
        return res;
    }

    private static void buildTree(List<List<String>> paths, Node root) {
        for (List<String> p : paths){
            Node cur = root;
            for (String s : p) {
                if (!cur.child.containsKey(s)) {
                    cur.child.put(s, new Node());
                }
                cur = cur.child.get(s);
            }
        }
    }

    private static class Node {
        Map<String, Node> child = new TreeMap<>();
        boolean isDeleted = false;
    }

}