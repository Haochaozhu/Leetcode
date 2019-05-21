import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int prev = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1) && prev != -1) {
                    dist = Math.min(dist, i - prev);
                    prev = i;
                } else if (words[i].equals(word1)) {
                    prev = i;
                }
            }
        } else {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals(word1) && !words[i].equals(word2)) continue;
                map.put(words[i], i);
                if (map.containsKey(word1) && map.containsKey(word2)) {
                    int cur = Math.abs(map.get(word1) - map.get(word2));
                    dist = Math.min(dist, cur);
                }
            }
        }
        return dist;
    }
}
