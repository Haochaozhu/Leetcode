import java.util.*;

/**
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation:
 * The path with the maximum score is highlighted in yellow.
 * Example 2:
 *
 *
 *
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 * Example 3:
 *
 *
 *
 * Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 */
public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        int min = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[2] - o1[2]));
        pq.offer(new int[]{0, 0, A[0][0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int val = cur[2];
            min = Math.min(min, val);
            if (x == m - 1 && y == n - 1) {
                return min;
            }
            for (int[] dir : dirs) {
                int p = x + dir[0];
                int q = y + dir[1];
                if (p >= 0 && q >= 0 && p < m && q < n && !visited[p][q]) {
                    visited[p][q] = true;
                    pq.offer(new int[]{p, q, A[p][q]});
                }
            }
        }
        return -1;
    }
}
