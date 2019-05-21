import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1,
 * except those cells in the given list mines which are 0.
 * What is the largest axis-aligned plus sign of 1s contained in the grid?
 * Return the order of the plus sign. If there is none, return 0.
 *
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1
 * along with 4 arms of length k-1 going up, down, left, and right, and made of 1s.
 * This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond
 * the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;

        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }

        return ans;
    }
}
