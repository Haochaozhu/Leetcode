/**
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInAString {
    /**
     * Brute force approach. Converts the string to an array containing only the words. Then swap.
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splits = s.split("\\s+");
        int lo = 0, hi = splits.length - 1;
        while (lo < hi) {
            String temp = splits[lo];
            splits[lo] = splits[hi];
            splits[hi] = temp;
            lo += 1;
            hi -= 1;
        }
        for (String str : splits) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
