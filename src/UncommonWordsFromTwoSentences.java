import java.util.ArrayList;
import java.util.HashMap;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String word : a) map.put(word, map.getOrDefault(word, 0) + 1);
        for (String word : b) map.put(word, map.getOrDefault(word, 0) + 1);
        for (String word : map.keySet()) {
            if (map.get(word) == 1) ans.add(word);
        }
        return ans.toArray(new String[0]);
    }
}
