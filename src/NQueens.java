import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such
 * that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        boolean[] rowUsed = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        dfs(0, board, ans, rowUsed, dia1, dia2);
        return ans;
    }

    private void dfs(int colIdx, char[][] board, List<List<String>> ans, boolean[] rowUsed, boolean[] dia1, boolean[] dia2) {
        if (colIdx == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!rowUsed[i] && !dia1[i + colIdx] && !dia1[i - colIdx]) {
                board[i][colIdx] = 'Q';
                rowUsed[i] = true;
                dia1[i + colIdx] = true;
                dia2[i - colIdx] = true;
                dfs(colIdx + 1, board, ans, rowUsed, dia1, dia2);
                board[i][colIdx] = '.';
                rowUsed[i] = false;
                dia1[i + colIdx] = false;
                dia2[i - colIdx] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> cur = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            cur.add(new String(board[i]));
        }
        return cur;
    }
}
