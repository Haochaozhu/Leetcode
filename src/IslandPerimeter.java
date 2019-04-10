/**
 * You are given a map in form of a two-dimensional integer grid
 * where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (grid[i][j] == 0) continue;
                int neighb = countNeighbour(grid, i + 1, j) + countNeighbour(grid, i - 1, j) +
                        countNeighbour(grid, i, j + 1) + countNeighbour(grid, i, j - 1);
                if (neighb == 1) perimeter += 3;
                if (neighb == 2) perimeter += 2;
                if (neighb == 3) perimeter += 1;
            }
        }
        return perimeter;
    }

    private int countNeighbour(int[][] grid, int m, int n) {
        if (m < 0 || m > grid.length - 1 || n < 0 || n > grid[0].length - 1) {
            return 0;
        }
        return grid[m][n] == 1 ? 1 : 0;
    }

}
