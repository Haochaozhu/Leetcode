import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Initially on a notepad only one character 'A' is present.
 * You can perform two operations on this notepad for each step:
 *
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 *
 *
 * Given a number n. You have to get exactly n 'A' on the notepad by
 * performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 *
 *
 * Note:
 *
 * The n will be in the range [1, 1000].
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int k = 2; k <= n; k++) {
            dp[k] = Integer.MAX_VALUE;
            for (int i = 1; i < k; i++) {
                if (k % i != 0) continue;
                dp[k] = Math.min(dp[k], dp[i] + k / i);
            }
        }
        return dp[n];
    }
}
