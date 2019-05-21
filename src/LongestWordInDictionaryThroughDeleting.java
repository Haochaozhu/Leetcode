import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a string and a string dictionary,
 * find the longest string in the dictionary that can be formed
 * by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with
 * the smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                else return o2.length() - o1.length();
            }
        });
        for (String st : d) if (canForm(s, st)) return st;
        return "";
    }
    private boolean canForm(String s, String word) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(word.charAt(j) == s.charAt(i)) j++;
        }
        return j == word.length();
    }
}
