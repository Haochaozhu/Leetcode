import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word1) && !words[i].equals(word2)) continue;
            map.put(words[i], i);
            if (map.containsKey(word1) && map.containsKey(word2)) {
                int cur = Math.abs(map.get(word1) - map.get(word2));
                dist = Math.min(dist, cur);
            }
        }
        return dist;
    }
}
