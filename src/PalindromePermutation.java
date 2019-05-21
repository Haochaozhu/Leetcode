/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] table = new int[256];
        for (char c : s.toCharArray()) {
            table[c]++;
        }
        int single = 0;
        for (int n : table) {
            if (n % 2 != 0) single++;
        }
        return single <= 1;
    }
}
