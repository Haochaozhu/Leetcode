import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int l = 0;
        int minLength = s.length() + 1;
        int minL = 0;
        Map<Character, Integer> map = new HashMap<>();
        int size = t.length();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int count = 0;
        for (int r = 0; r < s.length(); r += 1) {
            char cur = s.charAt(r);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) >= 0) count += 1;
                while (count == size) {
                    if (r - l + 1 < minLength) {
                        minLength = r - l + 1;
                        minL = l;
                    }
                    char start = s.charAt(l);
                    if (map.containsKey(start)) {
                        map.put(start, map.get(start) + 1);
                        if (map.get(start) > 0) {
                            count -= 1;
                        }
                    }
                    l += 1;
                }
            }
        }
        if (minLength > s.length()) return "";
        return s.substring(minL, minL + minLength);
    }
}
