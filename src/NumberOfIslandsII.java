import java.util.*;

/**
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate,
 * count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 *
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * Follow up:
 *
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberOfIslandsII {
    int res = 0;
    int count = 0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[] id = new int[m * n];
        int[] size = new int[m * n];
        Arrays.fill(id, -1);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] pos : positions) {
            int x = pos[0], y = pos[1];
            int cur = x * n + y;
            if (id[cur] == cur) continue;
            id[cur] = cur;
            size[cur] = 1;
            res++;
            for (int[] dir : dirs) {
                int p = x + dir[0];
                int q = y + dir[1];
                if (p < 0 || q >= m * n) continue;
                int idx = p * n + q;
                if (id[idx] != -1) {
                    if (x == 0 && y == 2) count++;

                    union(idx, cur, id, size);
                }
            }
            ans.add(res);
        }
        return ans;
    }
    private void union(int p, int q, int[] id, int[] size) {
        int rootP = find(p, id);
        int rootQ = find(q, id);
        if (rootP == rootQ) return;
        if (size[rootP] > size[rootQ]) {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        res--;
    }

    private int find(int p, int[] id) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
