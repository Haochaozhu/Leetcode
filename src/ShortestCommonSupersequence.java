import java.util.Arrays;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] lcs = LCS(str1, str2);
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : lcs) {
            while (str1.charAt(i) != c) {
                sb.append(str1.charAt(i++));
            }
            while (str2.charAt(j) != c) {
                sb.append(str2.charAt(j++));
            }
            sb.append(c);
            i++;
            j++;
        }
        while (i < str1.length()) {
            sb.append(str1.charAt(i++));
        }
        while (j < str2.length()) {
            sb.append(str2.charAt(j++));
        }
        return sb.toString();
    }

    private static char[] LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n].toCharArray();
    }

    public static void main(String[] args) {
        System.out.println(LCS("bbbaaaba", "bbababbb"));
    }
}
