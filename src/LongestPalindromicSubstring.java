import edu.princeton.cs.algs4.StdOut;

/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int N = s.length();
        if (N < 2) return s;
        String res = "";
        int maxLen = 0;

        for (int i = 0; i < N; i += 1) {
            if (isPalindrome(s, i - maxLen - 1, i)) {
                res = s.substring(i - maxLen - 1, i + 1);
                maxLen = maxLen + 2;
            }

            if (isPalindrome(s, i - maxLen, i)) {
                res = s.substring(i - maxLen, i + 1);
                maxLen = maxLen + 1;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i < 0) return false;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring p = new LongestPalindromicSubstring();
        StdOut.println(p.longestPalindrome("cbbd"));
    }

}