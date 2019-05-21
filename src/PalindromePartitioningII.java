import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < s.length(); i += 1) {
            int j = 0;
            for (; j < i; j += 1) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - 1 == j) dp[i] = dp[j];
                    else if (dp[i - 1] == dp[j + 1]) dp[i] = dp[j];
                    else dp[i] = dp[i - 1] + 1;
                }
            }
            if (dp[i] == Integer.MAX_VALUE) dp[i] = dp[i - 1] + 1;
        }
        return dp[s.length() - 1];
    }
}
