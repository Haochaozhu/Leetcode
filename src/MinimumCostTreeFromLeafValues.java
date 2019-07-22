/**
 * Given an array arr of positive integers, consider all binary trees such that:
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 * 48 + 24 + 12 = 60 + 24
 *
 *
 *        48             48
 *       /  \           / \
 *     24    8        24  8
 *    /  \           /  \
 *   12   4          6  8
 *  /  \               / \
 * 6    2             2  4
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n]; // min non-leaf sum between i, j
        int[][] max = new int[n][n]; // largest leaf value in the interval
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] * arr[i + 1];
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                int temp = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    temp = Math.min(temp, dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
                dp[i][j] = temp;
            }
        }
        return dp[0][n - 1];
    }
}

/**
 *
 * 12 + 24 = 36
 * 8 + 24 = 32
    6  2   4   8
 6  0  12

 2     0  8

 4        0

 8            8



 6 2 4

   2 4 8
 **/


//  6 2 4 8