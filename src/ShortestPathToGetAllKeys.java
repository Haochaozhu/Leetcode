import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 *
 * We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 *
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 *
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Example 2:
 *
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 */
public class ShortestPathToGetAllKeys {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int x = 0, y = 0, step = 0, m = grid.length, n = grid[0].length(), target = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    x = i;
                    y = j;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    target |= (1 << grid[i].charAt(j) - 'a');
                }
            }
        }
        que.add(new int[]{0, x, y});
        set.add(0 + " " + x + " " + y);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int state = cur[0];
                if (state == target) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int p = cur[1] + dir[0];
                    int q = cur[2] + dir[1];
                    if (p >= 0 && q >= 0 && p < m && q < n && grid[p].charAt(q) != '#') {
                        char c = grid[p].charAt(q);
                        int nextState = state;
                        if (c >= 'a' && c <= 'f') {
                            nextState |= (1 << c - 'a');

                        }
                        if (c >= 'A' && c <= 'F' && (nextState & (1 << c - 'A')) == 0) {
                            continue;
                        }
                        if (!set.contains(nextState + " " + p + " " + q)) {
                            set.add(nextState + " " + p + " " + q);
                            que.offer(new int[]{nextState, p, q});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int state = 0;
        state |= (1 << 'a' - 'a');
        state |= (1 << 'b' - 'a');
        state |= (1 << 'C' - 'A');
        System.out.println((state & (1 << 'C' - 'A')) == 0);
    }

}


/**
a b c d e f
 "@.a.#"
 "###.#"
 "b.A.B"


 @...a
 .###A
 b.BCc

 **/