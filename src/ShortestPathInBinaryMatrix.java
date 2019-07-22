import java.util.PriorityQueue;

/**
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 *
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 *
 *
 * Note:
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] is 0 or 1
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        int endX = m - 1;
        int endY = n - 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if (x == endX && y == endY) return dist + 1;
            for (int[] dir : dirs) {
                int p = x + dir[0];
                int q = y + dir[1];
                if (p >= 0 && q >= 0 && p < m && q < n && grid[p][q] != 1 && !visited[p][q]) {
                    pq.offer(new int[]{p, q, dist + 1});
                    visited[p][q] = true;
                }
            }
        }
        return -1;
    }
}
