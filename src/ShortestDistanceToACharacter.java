/**
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 * Note:
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
public class ShortestDistanceToACharacter {
    /**
     * 2 passes. Scan from left to right and then right to left.
     */
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int rightC = Integer.MIN_VALUE / 2;
        int leftC = Integer.MAX_VALUE / 2;
        for (int i = 0; i < N; i += 1) {
            if (S.charAt(i) == C) rightC = i;
            ans[i] = i - rightC;
        }
        for (int i = N - 1; i > 0; i -= 1) {
            if (S.charAt(i) == C) leftC = i;
            ans[i] = Math.min(ans[i], leftC - i);
        }
        return ans;
    }

}
