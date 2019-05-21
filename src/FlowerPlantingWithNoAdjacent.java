import java.util.*;

/**
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
 *
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
 *
 * Also, there is no garden that has more than 3 paths coming into or leaving it.
 *
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path,
 * they have different types of flowers.
 *
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.
 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 *
 * Example 1:
 *
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: N = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * Example 3:
 *
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * Note:
 *
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * No garden has 4 or more paths coming into or leaving it.
 * It is guaranteed an answer exists.
 */
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] ans = new int[N];
        ArrayList<Integer>[] gardens = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            gardens[i] = new ArrayList<>();
        }
        for (int i = 0; i < paths.length; i++) {
            int garden = paths[i][0];
            int adj = paths[i][1];
            gardens[garden].add(adj);
            gardens[adj].add(garden);
        }
        for (int i = 1; i <= N; i++) {
            paint(i, gardens, ans);
        }
        return ans;
    }
    private void paint(int gd, ArrayList<Integer>[] neighbors, int[] ans) {
        if (ans[gd - 1] == 0) ans[gd - 1] = 1;
        for (int neighb : neighbors[gd]) {
            if (ans[neighb - 1] == 0) {
                int color = getColor(ans, neighb, neighbors);
                ans[neighb - 1] = color;
            }
        }
    }

    private int getColor(int[] ans, int garden, ArrayList<Integer>[] neighbors) {
        Set<Integer> colors = new HashSet<>(4);
        for (int n : neighbors[garden]) {
            if (ans[n - 1] != 0) {
                colors.add(ans[n - 1]);
            }
        }
        for (int i = 2; i <= 4; i++) {
            if (!colors.contains(i)) return i;
        }
        return 0;
    }
}
