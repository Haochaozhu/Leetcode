/**
 * Given string S and a dictionary of words words,
 * find the number of words[i] that is a subsequence of S.
 *
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * Note:
 *
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSub(word, S)) count++;
        }
        return count;
    }
    public boolean isSub(String s, String t) {
        if (s.isEmpty()) return true;
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) indexS += 1;
            if (indexS == s.length()) return true;
            indexT += 1;
        }
        return false;
    }
}
