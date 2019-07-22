import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 * Note:
 *
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        String ans = "";
        if (words == null || words.length == 0) return ans;
        Map<Character, HashSet<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String m = words[i];
            String n = words[i + 1];
            for (int j = 0; j < Math.min(m.length(), n.length()); j++) {
                char c1 = m.charAt(j);
                char c2 = n.charAt(j);
                if (c1 == c2) continue;
                HashSet<Character> temp = map.getOrDefault(c1, new HashSet<>());
                if (!temp.contains(c2)) {
                    temp.add(c2);
                    map.put(c1, temp);
                    degree.put(c2, degree.getOrDefault(c2, 0) + 1);
                }
                break;
            }
        }
        Queue<Character> que = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                ans += c;
                que.offer(c);
            }
        }
        while (!que.isEmpty()) {
            char cur = que.poll();
            if (map.containsKey(cur)) {
                for (char w : map.get(cur)) {
                    degree.put(w, degree.get(w) - 1);
                    if (degree.get(w) == 0) {
                        ans += w;
                        que.offer(w);
                    }
                }
            }
        }
        if (ans.length() != degree.size()) return "";
        return ans;
    }
}
