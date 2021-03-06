import java.util.Arrays;

/**
 * Given two strings s1 and s2, write a function to
 * return true if s2 contains the permutation of s1.
 * In other words, one of the first string's
 * permutations is the substring of the second string.
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] pattern = new int[26];
        for (char c : s1.toCharArray()) pattern[c - 'a']++;
        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            temp[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(pattern, temp)) return true;
            temp[s2.charAt(i - s1.length()) - 'a']--;
            temp[s2.charAt(i) - 'a']++;
        }
        return false;
    }
}
