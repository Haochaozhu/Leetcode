import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, S.toCharArray(), 0);
        return ans;
    }

    private void backtrack(List<String> ans, char[] chars, int pos) {
        if (pos == chars.length) {
            ans.add(new String(chars));
            return;
        }
        if (chars[pos] >= '0' || chars[pos] <= '9') {
            backtrack(ans, chars, pos + 1);
            return;
        }
        chars[pos] = Character.toUpperCase(chars[pos]);
        backtrack(ans, chars, pos + 1);
        chars[pos] = Character.toLowerCase(chars[pos]);
        backtrack(ans, chars, pos + 1);
    }

    public static void main(String[] args) {
    }
}
