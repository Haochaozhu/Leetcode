public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int p = i + 1; p < m; p++) {
                    if (grid[p][j] == 0) continue;
                    for (int q = j + 1; q < n; q++) {
                        if (grid[i][q] == 0) continue;
                        res += grid[p][q];
                    }
                }
            }
        }
        return res;
    }
}
