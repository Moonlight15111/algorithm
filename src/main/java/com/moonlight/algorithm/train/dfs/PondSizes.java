package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pond-sizes-lcci/
 *
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * 输入：[ [0,2,1,0], [0,1,0,1], [1,1,0,1], [0,1,0,1] ]
 * 输出： [1,2,4]
 *
 * @author Moonlight
 */
public class PondSizes {

    public static void main(String[] args) {
        int[][] a = {
                {0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}
        };
        System.out.println(Arrays.toString(pondSizes(a)));
    }

    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int r = dfs(i, j, land);
                    if (r != 0) {
                        list.add(r);
                    }
                }
            }
        }

        int[] ans = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ans);
        return ans;
    }

    private static int dfs(int r, int c, int[][] land) {
        if (r < 0 || c < 0 || r >= land.length || c >= land[0].length || land[r][c] != 0) {
            return 0;
        }
        land[r][c] = -1;
        return 1 + dfs(r + 1, c, land)
                + dfs(r - 1, c, land)
                + dfs(r, c + 1, land)
                + dfs(r, c - 1, land)
                + dfs(r + 1, c + 1, land)
                + dfs(r + 1, c - 1, land)
                + dfs(r - 1, c + 1, land)
                + dfs(r - 1, c - 1, land);
    }

}
