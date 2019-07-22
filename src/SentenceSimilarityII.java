import java.util.*;
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> lst : pairs) {
            String s1 = lst.get(0);
            String s2 = lst.get(1);
            map.putIfAbsent(s1, new HashSet<>());
            map.putIfAbsent(s2, new HashSet<>());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i];
            String s2 = words2[i];
            if (s1.equals(s2)) continue;
            if (!map.containsKey(s1)) return false;
            if (!dfs(map, s1, s2, new HashSet<>())) return false;
        }
        return true;
    }

    private boolean dfs(Map<String, Set<String>> map, String s1, String s2, Set<String> visited) {
        if (map.get(s1).contains(s2)) return true;
        if (!visited.contains(s1)) {
            visited.add(s1);
            for (String w : map.get(s1)) {
                if (dfs(map, w, s2, visited)) return true;
            }
        }
        return false;
    }
}
