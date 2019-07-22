import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
 *
 * We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
 *
 * Return true if and only if it is possible to reach the target square through a sequence of moves.
 *
 *
 *
 * Example 1:
 *
 * Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * Output: false
 * Explanation:
 * The target square is inaccessible starting from the source square, because we can't walk outside the grid.
 * Example 2:
 *
 * Input: blocked = [], source = [0,0], target = [999999,999999]
 * Output: true
 * Explanation:
 * Because there are no blocked cells, it's possible to reach the target square.
 *
 *
 * Note:
 *
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 */
public class EscapeALargeMaze {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();
        for (int[] block : blocked) blocks.add("" + block[0] + block[1]);
        return check(blocks, source, target) && check(blocks, target, source);
    }
    private boolean check(Set<String> blocks, int[] start, int[] end) {
        int max = blocks.size();
        Queue<int[]> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add("" + start[0] + start[1]);
        que.offer(start);
        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                if (cur[0] == end[0] && cur[1] == end[1]) return true;
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : dirs) {
                    int p = x + dir[0];
                    int q = y + dir[1];
                    if (p >= 0 && q >= 0 && p < 1000000 && q < 1000000 && !blocks.contains("" + p + q) && !visited.contains("" + p + q)) {
                        que.offer(new int[]{p, q});
                        visited.add("" + p + q);
                    }
                }
            }
            if (level > max && !que.isEmpty()) return true;
            level++;
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("" + 1 + 2);
        System.out.println(set.contains("" + 1 + 2));
    }
}
