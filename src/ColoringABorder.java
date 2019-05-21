/**
 * Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.
 *
 * Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.
 *
 * The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 *
 * Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * Output: [[3, 3], [3, 2]]
 * Example 2:
 *
 * Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * Output: [[1, 3, 3], [2, 3, 3]]
 * Example 3:
 *
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 */
public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int base = grid[r0][c0];
        boolean[][] component = new boolean[m][n];
        dfs(component, r0, c0, base, grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (component[i][j]) {
                    if (isBorder(component, i, j)) grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    private void dfs(boolean[][] component, int i, int j, int base, int[][] grid) {
        if (i < 0 || i >= component.length || j < 0 || j >= component[0].length || grid[i][j] != base) return;
        if (component[i][j]) return;
        component[i][j] = true;
        dfs(component, i + 1, j, base, grid);
        dfs(component, i - 1, j, base, grid);
        dfs(component, i, j + 1, base, grid);
        dfs(component, i, j - 1, base, grid);
    }
    private boolean isBorder(boolean[][] component, int i, int j) {
        if (i == 0 || i == component.length - 1 || j == 0 || j == component[0].length - 1) return true;
        if (!component[i + 1][j] || !component[i - 1][j] || !component[i][j + 1] || !component[i][j - 1]) {
            return true;
        }
        return false;
    }
}

