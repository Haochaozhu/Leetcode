/**
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 *
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 *
 * Example 1:
 *
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: [[1, 1], [1, 0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: [[1, 1], [1, 1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 *
 * Notes:
 *
 * 1 <= grid.length = grid[0].length <= 50.
 * 0 <= grid[i][j] <= 1.
 *
 */
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(new boolean[m][n], i, j, grid));
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? m * n : max;
    }

    private int dfs(boolean[][] visited, int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length
                || visited[i][j] || grid[i][j] == 0) return 0;
        int count = 0;
        visited[i][j] = true;
        count += dfs(visited, i + 1, j, grid) + dfs(visited, i - 1, j, grid)
                + dfs(visited, i, j + 1, grid) + dfs(visited, i, j - 1, grid);
        return count + 1;
    }
}
