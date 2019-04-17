import java.util.HashMap;

/**
 * Share
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 *
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with
 * 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 *
 *
 *
 * Example 1:
 *
 * Input: [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 *
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 *
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 *
 *
 * Note:
 *
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        int ans = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[A.length]; // Difference <-> longest length for that difference
        for (int i = 0; i < A.length; i += 1) {
            dp[i] = new HashMap<>();
        }
        for (int i = 1; i < A.length; i += 1) {
            int cur = A[i];
            for (int j = 0; j < i; j += 1) {
                int n = A[j];
                int diff = cur - n;
                int len = 2;
                if (dp[j].containsKey(diff)) {
                    len = dp[j].get(diff) + 1;
                }
                int oldValue = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, Math.max(len, oldValue));
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}
