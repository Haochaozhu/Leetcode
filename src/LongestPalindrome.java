import java.util.HashSet;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    /**
     * Brute force solution. In a palindrome, each character appears in pairs or alone(in the middle).
     * Iterate through the string, add the character if it is not present in the set, otherwise remove and increase count.
     * After iteration, if set is empty, length will be even as count*2 because each char in the string appears 2 times(or 4,,6,8).
     * If set is not empty, length should be odd as count*2 + 1 because single number can be choosen to be in the middle of the palindrome.
     * Time complexity: O(n)
     * Space complexity: O(n) worst case: each char of the string is unique
     */
    public int longestPalindrome1(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count += 1;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }


}
