/**
 * We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".)
 *
 * A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i:
 *
 * If S[i] == 'D', then P[i] > P[i+1], and;
 * If S[i] == 'I', then P[i] < P[i+1].
 * How many valid permutations are there?  Since the answer may be large, return your answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: "DID"
 * Output: 5
 * Explanation:
 * The 5 valid permutations of (0, 1, 2, 3) are:
 * (1, 0, 3, 2)
 * (2, 0, 3, 1)
 * (2, 1, 3, 0)
 * (3, 0, 2, 1)
 * (3, 1, 2, 0)
 *
 *
 * Note:
 *
 * 1 <= S.length <= 200
 * S consists only of characters from the set {'D', 'I'}.
 */
public class ValidPermutationsForDISequence {
    public int numPermsDISequence(String S) {
        int mod = 1_000_000_007;
        int n = S.length();
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (S.charAt(i - 1) == 'D') {
                    for (int k = j; k <= i - 1; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    for (int k = 0; k <= j - 1; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res += dp[n][i];
            res %= mod;
        }
        return (int)res;
    }
}

/**
 *
 * "D"
 * len = 1
 * {0, 1}
 *
 * 1, 0
 *
 * "DI" --> min in middle
 * len = 2
 * {0, 1, 2}
 *
 * 1, 0, 2
 * 2, 0, 1
 *
 * "ID" --> max in middle
 * len = 2
 * {0, 1, 2}
 *
 * 1,2,0
 * 0,2,1
 *
 *
 *
 */
