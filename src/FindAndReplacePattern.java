import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isMatched(word, pattern)) ans.add(word);
        }
        return ans;
    }

    private static boolean isMatched(String word, String pattern) {
        Map<Character, Character> wd = new HashMap<>();
        Map<Character, Character> pt = new HashMap<>();
        for (int i = 0; i < word.length(); i += 1) {
            if (wd.containsKey(word.charAt(i))) {
                if (wd.get(word.charAt(i)) != pattern.charAt(i)) return false;
            } else {
                wd.put(word.charAt(i), pattern.charAt(i));
            }
            if (pt.containsKey(pattern.charAt(i))) {
                if (pt.get(pattern.charAt(i)) != word.charAt(i)) return false;
            } else {
                pt.put(pattern.charAt(i), word.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatched("tkk", "clk"));
    }
}
