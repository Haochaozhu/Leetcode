import edu.princeton.cs.algs4.StdOut;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */
public class DecodeWays {
    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == 0 ? 0 : 1;
        for (int i = 2; i <= s.length(); i += 1) {
            int singleDigit = Integer.valueOf(s.substring(i - 1, i));
            int doubleDigit = Integer.valueOf(s.substring(i - 2, i));
            if (singleDigit != 0) dp[i] += dp[i - 1];
            if (doubleDigit >= 10 && doubleDigit <= 26) dp[i] += dp[i - 2];
        }
        return dp[1];
    }
    public static void main(String[] args) {
        StdOut.println(numDecodings("0"));
    }
}
