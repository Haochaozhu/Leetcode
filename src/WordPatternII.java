/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection
 * between a letter in pattern and a non-empty substring in str.
 *
 * Example 1:
 *
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * Example 2:
 *
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * Example 3:
 *
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */
import java.util.*;
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return backtrack(pattern, 0, str, 0, map, set);
    }

    private boolean backtrack(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;
        char cur = pattern.charAt(i);
        if (map.containsKey(cur)) {
            if (!str.startsWith(map.get(cur), j)) return false;
            return backtrack(pattern, i + 1, str, j + map.get(cur).length(), map, set);
        }
        for (int k = j; k < str.length(); k++) {
            String temp = str.substring(j, k + 1);
            if (set.contains(temp)) continue;
            map.put(cur, temp);
            set.add(temp);
            if (backtrack(pattern, i + 1, str, k + 1, map, set)) return true;
            map.remove(cur);
            set.remove(temp);
        }
        return false;
    }

}
