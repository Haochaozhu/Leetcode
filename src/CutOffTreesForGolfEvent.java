import java.util.*;

/**
 * You are asked to cut off trees in a forest for a golf event.
 * The forest is represented as a non-negative 2D map, in this map:
 *
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through,
 * and this positive number represents the tree's height.
 *
 *
 * You are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after cutting,
 * the original place has the tree will become a grass (value 1).
 *
 * You will start from the point (0, 0) and you should output
 * the minimum steps you need to walk to cut off all the trees.
 * If you can't cut off all the trees, output -1 in that situation.
 *
 * You are guaranteed that no two trees have the same height and there
 * is at least one tree needs to be cut off.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * Output: -1
 *
 *
 * Example 3:
 *
 * Input:
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 */
public class CutOffTreesForGolfEvent {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int ans = 0;
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        int[] start = {0, 0};
        while (!pq.isEmpty()) {
            int[] target = pq.poll();
            int step = bfs(start, target, forest, forest.size(), forest.get(0).size());
            if (step == -1) return -1;
            ans += step;
            start[0] = target[0];
            start[1] = target[1];
        }
        return ans;
    }

    private int bfs(int[] start, int[] target, List<List<Integer>> forest, int m, int n) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        int step = 0;
        que.offer(start);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int p = cur[0];
                int q = cur[1];
                if (target[0] == p && target[1] == q) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int x = p + dir[0];
                    int y = q + dir[1];
                    if (x == target[0] && y == target[1]) {
                        return step + 1;
                    }
                    if (x >= 0 && y >= 0 && x < m && y < n && forest.get(x).get(y) != 0
                            && !visited[x][y]) {
                        visited[x][y] = true;
                        que.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
