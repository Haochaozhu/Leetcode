import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column
 * from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 *
 * Example:
 *
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * Placing a bomb at (1,1) kills 3 enemies.
 */
public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    up[i][j] = goUp(grid, up, i - 1, j, 0);
                    left[i][j] = goLeft(grid, left, i, j - 1, 0);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == '0') {
                    right[i][j] = goRight(grid, right, i, j + 1, 0);
                    down[i][j] = goDown(grid, down, i + 1, j, 0);
                    int cur = right[i][j] + down[i][j] + up[i][j] + left[i][j];
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    private int goUp(char[][] grid, int[][] up, int i, int j, int val) {
        if (i < 0 || grid[i][j] == 'W') return val;
        if (grid[i][j]== 'E') {
            val++;
        } else {
            val += up[i][j];
            return val;
        }
        return goUp(grid, up, i - 1, j, val);
    }

    private int goLeft(char[][] grid, int[][] left, int i, int j, int val) {
        if (j < 0 || grid[i][j] == 'W') return val;
        if (grid[i][j]== 'E') {
            val++;
        } else {
            val += left[i][j];
            return val;
        }
        return goLeft(grid, left, i, j - 1, val);
    }

    private int goRight(char[][] grid, int[][] right, int i, int j, int val) {
        if (j >= grid[0].length || grid[i][j] == 'W') return val;
        if (grid[i][j]== 'E') {
            val++;
        } else {
            val += right[i][j];
            return val;
        }
        return goRight(grid, right, i, j + 1, val);
    }

    private int goDown(char[][] grid, int[][] down, int i, int j, int val) {
        if (i >= grid.length || grid[i][j] == 'W') return val;
        if (grid[i][j]== 'E') {
            val++;
        } else {
            val += down[i][j];
            return val;
        }
        return goDown(grid, down, i + 1, j, val);
    }

}
