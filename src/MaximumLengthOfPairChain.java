import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 *
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class MaximumLengthOfPairChain {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int maxLength = 0;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int j = 1; j < pairs.length; j += 1) {
            for (int i = 0; i < j; i += 1) {
                if (pairs[j][0] > pairs[i][1]) dp[j] = Math.max(dp[j], dp[i] + 1);
            }
            maxLength = Math.max(maxLength, dp[j]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
    }
}
