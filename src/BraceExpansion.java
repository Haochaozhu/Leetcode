import java.util.ArrayList;
import java.util.Collections;

/**
 * A string S represents a list of words.
 *
 * Each letter in the word has 1 or more options.
 * If there is one option, the letter is represented as is.
 * If there is more than one option, then curly braces delimit the options.
 * For example, "{a,b,c}" represents options ["a", "b", "c"].
 *
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
 *
 * Return all words that can be formed in this manner, in lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * Example 2:
 *
 * Input: "abcd"
 * Output: ["abcd"]
 *
 *
 * Note:
 *
 * 1 <= S.length <= 50
 * There are no nested curly brackets.
 * All characters inside a pair of consecutive opening and ending curly brackets are different.
 */
public class BraceExpansion {
    private ArrayList<String> lst = new ArrayList<>();
    public String[] expand(String S) {
        backtrack(new StringBuilder(), S, 0);
        String[] ans = new String[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }

    private void backtrack(StringBuilder sb, String S, int idx) {
        if (idx == S.length()) lst.add(sb.toString());
        else {
            if (S.charAt(idx) == '{') {
                ArrayList<Character> temp = new ArrayList<>();
                while (S.charAt(idx) != '}') {
                    if (Character.isLetter(S.charAt(idx))) {
                        temp.add(S.charAt(idx));
                    }
                    idx++;
                }
                Collections.sort(temp);
                idx++;
                for (char c : temp) {
                    sb.append(c);
                    backtrack(sb, S, idx);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(S.charAt(idx));
                backtrack(sb, S, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
