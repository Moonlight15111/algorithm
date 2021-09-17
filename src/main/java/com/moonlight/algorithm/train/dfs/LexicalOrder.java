import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 给定 n = 13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class LexicalOrder {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
        System.out.println(convertToString(13));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, n, 0);
        return ans;
    }

    private static void dfs(List<Integer> ans, int n, int i) {
        for (int j = 0; j <= 9; j++) {
            if (j == 0 && i == 0) {
                continue;
            }
            if ((i * 10 + j) > n) {
                return;
            }
            ans.add(i * 10 + j);
            dfs(ans, n, i * 10 + j);
        }
    }

    public static List<Integer> convertToString(int n) {
        List<String> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(String::compareTo);
        for (int i = 0; i < n; i++) {
            ans.add(Integer.valueOf(list.get(i)));
        }
        return ans;
    }

}