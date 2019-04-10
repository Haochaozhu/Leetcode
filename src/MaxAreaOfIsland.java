/**
 * Given a non-empty 2D array grid of 0's and 1's, an island
 * is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11,
 * because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int maxArea = 0;
        for (int i = 0; i < R; i += 1) {
            for (int j = 0; j < C; j += 1) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int m, int n, boolean[][] visited) {
        if (m < 0 || m > grid.length - 1 || n < 0 || n > grid[0].length - 1) {
            return 0;
        }
        if (visited[m][n]) return 0;
        visited[m][n] = true;
        return (grid[m][n] == 1 ? 1 : 0) + dfs(grid, m + 1, n, visited) + dfs(grid, m - 1, n, visited)
                + dfs(grid, m, n + 1, visited) + dfs(grid, m, n - 1, visited);
    }

}
/**
 *  1 1 0 0 0
 *  1 1 0 0 0
 *  0 0 0 1 1
 *  0 0 0 1 1
 **/