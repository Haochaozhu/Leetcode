import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cur = s.toCharArray();
            Arrays.sort(cur);
            String sorted = String.valueOf(cur);
            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            else map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
