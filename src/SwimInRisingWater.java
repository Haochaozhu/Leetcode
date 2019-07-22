import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 *
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 *
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 *
 * Example 1:
 *
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 *
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * Example 2:
 *
 * Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 *  0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 *
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * Note:
 *
 * 2 <= N <= 50.
 * grid[i][j] is a permutation of [0, ..., N*N - 1].
 */
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Set<String> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]]);
        pq.offer(new int[]{0, 0});
        visited.add(0 + " " + 0);
        int max = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            max = Math.max(max, grid[x][y]);
            if (x == n - 1 && y == n - 1) return max;
            for (int[] dir : dirs) {
                int p = x + dir[0];
                int q = y + dir[1];
                String pos = p + " " + q;
                if (p >= 0 && q >= 0 && p < n && q < n && !visited.contains(pos)) {
                    visited.add(pos);
                    pq.offer(new int[]{p, q});
                }
            }
        }
        return max;
    }
}
