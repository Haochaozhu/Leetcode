import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    /**
     * Use two pointers, scan both from left to right and right to left.
     */
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int p = 0, q = s.length() - 1;
        char[] s_array = s.toCharArray();
        while (p < q) {
            if (vowels.contains(s.charAt(p)) && vowels.contains(s.charAt(q))) {
                swap(s_array, p, q);
                p += 1;
                q -= 1;
            } else if (vowels.contains(s.charAt(p))) {
                p += 1;
            } else if (vowels.contains(s.charAt(q))){
                q -= 1;
            } else {
                p += 1;
                q -= 1;
            }
        }
        return new String(s_array);
    }

    private void swap(char[] chars, int p, int q) {
        char temp = chars[p];
        chars[p] = chars[q];
        chars[q] = temp;
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString r = new ReverseVowelsOfAString();
        r.reverseVowels("hello");
    }
}
