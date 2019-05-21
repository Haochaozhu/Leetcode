import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return
 * the shortest distance between these two words in the list.
 * Your method will be called repeatedly many times with different parameters.
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
public class ShortestWordDistanceII {
    String[] w;
    Map<String, List<Integer>> dict;
    public ShortestWordDistanceII(String[] words) {
        w = new String[words.length];
        dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) w[i] = words[i];
        for (int i = 0; i < words.length; i++) {
            if (!dict.containsKey(words[i])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                dict.put(words[i], temp);
            } else dict.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = dict.get(word1);
        List<Integer> list2 = dict.get(word2);
        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if(index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }
}
