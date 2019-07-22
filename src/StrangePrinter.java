import java.util.HashMap;
import java.util.Map;

/**
 * There is a strange printer with the following two special requirements:
 *
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and
 * ending at any places, and will cover the original existing characters.
 * Given a string consists of lower English letters only, your job is to count
 * the minimum number of turns the printer needed in order to print it.
 *
 * Example 1:
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * Example 2:
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 * Hint: Length of the given string will not exceed 100.
 *
 * i k j
 *
 * a b a
 *
 * a + ba
 *
 * ab + a
 *
 *
 * a a a b b c c
 */
public class StrangePrinter {
    private int[][] dp;
    public int strangePrinter(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        s = preProcess(s);
        int n = s.length();
        dp = new int[n][n];
        return minStepBetween(s, 0, s.length() - 1);
    }

    private int minStepBetween(String s, int i, int j) {
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
        int minStep = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = minStepBetween(s, i, k) + minStepBetween(s, k + 1, j);
            if (s.charAt(i) == s.charAt(j)) {
                temp--;
            }
            minStep = Math.min(minStep,temp);
        }
        dp[i][j] = minStep;
        return minStep;
    }

    private String preProcess(String s ) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            }
        }
        return new String(sb);
    }
}
