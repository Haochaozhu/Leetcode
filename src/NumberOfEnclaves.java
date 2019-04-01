/**
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 *
 * A move consists of walking from one land square 4-directionally to another land square,
 * or off the boundary of the grid.
 *
 * Return the number of land squares in the grid for which we cannot walk off the boundary of
 * the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
 * Example 2:
 *
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation:
 * All 1s are either on the boundary or can reach the boundary.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * All rows have the same size.
 */
public class NumberOfEnclaves {
    public static int numEnclaves(int[][] A) {
        int R = A.length, C = A[0].length, count = 0;
        for (int i = 0; i < C; i += 1) {
            sink(A, 0, i);
        }
        for (int i = 0; i < C; i += 1) {
            sink(A, R - 1, i);
        }
        for (int i = 0; i < R; i += 1) {
            sink(A, i, 0);
        }
        for (int i = 0; i < R; i += 1) {
            sink(A, i, C - 1);
        }
        for (int i = 1; i < R - 1; i += 1) {
            for (int j = 1; j < C - 1; j += 1) {
                if (A[i][j] == 1) count += 1;
            }
        }
        return count;
    }

    private static void sink(int[][] A, int r, int c) {
        int R = A.length, C = A[0].length;
        if (r < 0 || r > R - 1 || c < 0 || c > C - 1) {
            return;
        }
        if (A[r][c] == 1) {
            A[r][c] = -1;
        } else {
            return;
        }
        sink(A, r + 1, c);
        sink(A, r - 1, c);
        sink(A, r, c + 1);
        sink(A, r, c - 1);
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,0,0,0}, {1,0,1,0},{0,1,1,0},{0,0,0,0}};
        numEnclaves(A);
        for (int i = 0; i < A.length; i += 1) {
            for (int j = 0; j < A[0].length; j += 1) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }
}
