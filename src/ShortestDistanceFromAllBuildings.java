import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings
 * in the shortest amount of distance. You can only move up, down, left and right.
 * You are given a 2D grid of values 0, 1 or 2, where:
 *
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 *
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * Output: 7
 *
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 *              the point (1,2) is an ideal empty land to build a house, as the total
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] dist = new int[m][n];
        boolean[][] visited;
        int[][] reach = new int[m][n];
        int buildings = 0;
        Queue<int[]> que;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    int steps = 1;
                    que = new LinkedList<>();
                    visited = new boolean[m][n];
                    que.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!que.isEmpty()) {
                        int size = que.size();
                        for (int w = 0; w < size; w++) {
                            int[] cur = que.poll();
                            int x = cur[0];
                            int y = cur[1];
                            for (int[] dir : dirs) {
                                int p = x + dir[0];
                                int q = y + dir[1];
                                if (p >= 0 && q >= 0 && p < m && q < n && !visited[p][q] && grid[p][q] == 0) {
                                    dist[p][q] += steps;
                                    visited[p][q] = true;
                                    que.add(new int[]{p, q});
                                    reach[p][q]++;
                                }
                            }
                        }
                        steps++;
                    }
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == buildings) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
