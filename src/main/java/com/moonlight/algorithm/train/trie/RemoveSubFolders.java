package com.moonlight.algorithm.train.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem/
 * <p>
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * 我们这样定义「子文件夹」：
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
 * / 后跟一个或者多个小写英文字母。
 * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
 * <p>
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 /
 * folder[i] 总是以字符 / 起始
 * 每个文件夹名都是唯一的
 * <p>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]  输出：["/a","/c/d","/c/f"]
 * 解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]  输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * <p>
 * 输入：folder = ["/a/b/c","/a/b/d","/a/b/ca"] 输出：["/a/b/c","/a/b/ca","/a/b/d"]
 *
 * @author Moonlight
 */
public class RemoveSubFolders {

    public static void main(String[] args) {
        String[] a = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}, b = {"/a", "/a/b/c", "/a/b/d"},
                c = {"/a/b/c", "/a/b/d", "/a/b/ca"};

        System.out.println(removeSubFolders(a));
        System.out.println(removeSubFolders(b));
        System.out.println(removeSubFolders(c));
    }

    static Node root;
    public static List<String> removeSubFolders(String[] folder) {
        List<String> ans = new ArrayList<>();

        build(folder);

        Node cur;
        String[] split;
        for (String f : folder) {
            cur = root;
            split = f.split("/");
            for (String s : split) {
                if ("".equals(s)) {
                    continue;
                }
                if (!cur.child.containsKey(s)) {
                    ans.add(f);
                    break;
                }
                if (cur.child.containsKey(s) && cur.child.get(s).isLast) {
                    if (!ans.contains(cur.child.get(s).fold)) {
                        ans.add(cur.child.get(s).fold);
                    }
                    break;
                }
                cur = cur.child.get(s);
            }
        }

        return ans;
    }

    private static void build(String[] folder) {
        Node cur;
        String[] split;
        root = new Node();
        for (String f : folder) {
            cur = root;

            split = f.split("/");
            for (String s : split) {
                if ("".equals(s)) {
                    continue;
                }
                if (!cur.child.containsKey(s)) {
                    cur.child.put(s, new Node());
                }
                cur = cur.child.get(s);
            }

            cur.isLast = true;
            cur.fold = f;
        }
    }

    private static class Node {
        boolean isLast;
        Map<String, Node> child;
        String fold;

        public Node() {
            this.isLast = false;
            this.child = new HashMap<>();
        }
    }

}
