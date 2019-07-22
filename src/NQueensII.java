import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueensII {
    int ans = 0;
    public int totalNQueens(int n) {
        boolean[] rowUsed = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        dfs(0, n, rowUsed, dia1, dia2);
        return ans;
    }

    private void dfs(int colIdx, int n, boolean[] rowUsed, boolean[] dia1, boolean[] dia2) {
        if (colIdx == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!rowUsed[i] && !dia1[i + colIdx] && !dia2[i - colIdx + n - 1]) {
                rowUsed[i] = true;
                dia1[i + colIdx] = true;
                dia2[i - colIdx + n - 1] = true;
                dfs(colIdx + 1, n, rowUsed, dia1, dia2);
                rowUsed[i] = false;
                dia1[i + colIdx] = false;
                dia2[i - colIdx + n - 1] = false;
            }
        }
    }
}
