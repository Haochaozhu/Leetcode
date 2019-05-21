import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.
 * An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.
 * (It is guaranteed that the answer is at least 1.)
 * Example 1:
 *
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 * Note:
 *
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 */
public class ShortestBridge {
    public static int shortestBridge(int[][] A) {
        Queue<int[]> pos = new LinkedList<>();
        int m = A.length;
        boolean stop = false;
        for (int i = 0; i < m; i++) {
            if (stop) break;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    sink(A, i, j, pos);
                    stop = true;
                    break;
                }
            }
        }
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (!pos.isEmpty()) {
            int size = pos.size();
            for (int i = 0; i < size; i += 1) {
                int[] cur = pos.poll();
                for (int[] dir : dirs) {
                    int p = cur[0] + dir[0];
                    int q = cur[1] + dir[1];
                    if (p >= 0 && p < m && q >= 0 && q < m && A[p][q] != -1) {
                        if (A[p][q] == 1) return step;
                        A[p][q] = -1;
                        pos.offer(new int[]{p, q});
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private static void sink(int[][] A, int i, int j, Queue<int[]> pos) {
        if (i < 0 || i >= A.length || j < 0 || j >= A.length) return;
        if (A[i][j] != 1) return;
        A[i][j] = -1;
        pos.offer(new int[]{i, j});
        sink(A, i + 1, j, pos);
        sink(A, i - 1, j, pos);
        sink(A, i, j + 1, pos);
        sink(A, i, j - 1, pos);
    }

    public static void main(String[] args) {
        int[][] t = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        shortestBridge(t);
        for (int[] k : t) {
            for (int n : k) System.out.print(n + "      ");
            System.out.println();
        }
    }
}
