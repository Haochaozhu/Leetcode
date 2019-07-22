/**
 * Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left.
 * Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1),
 * remove them and get k*k points.
 * Find the maximum points you can get.
 *
 * Example 1:
 * Input:
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * Output:
 * 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 * ----> [1, 3, 3, 3, 1] (1*1=1 points)
 * ----> [1, 1] (3*3=9 points)
 * ----> [] (2*2=4 points)
 * Note: The number of boxes n would not exceed 100.
 *
 * max(2, 2) = 4
 *
 * max(2, 3) = 2
 *
 * 3, 2, 2, 2, 2,
 * max(2, 3, 2) =
 */
public class RemoveBoxes {
    private int[][] dp;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n];
        return dfs(boxes, 0, n - 1);
    }

    private int dfs(int[] boxes, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            dp[i][j] = 1;
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int k = i;
        int cur = 0;
        int maxScore = 0;
        while (k <= j) {
            int len = 0;
            int left = k - 1;
            int val = boxes[k];
            while (k <= j && boxes[k] == val) {
                len++;
                k++;
            }
            cur = dfs(boxes, i, left) + dfs(boxes, k, j) + len * len;
            maxScore = Math.max(maxScore, cur);
        }
        dp[i][j] = maxScore;
        return maxScore;
    }

}
