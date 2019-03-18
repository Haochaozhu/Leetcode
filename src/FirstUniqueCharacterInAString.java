import java.util.HashMap;
import java.util.Map;
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.


 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += 1) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else map.put(cur, 1);
        }

        for (int i = 0; i < s.length(); i += 1) {
            char cur = s.charAt(i);
            if (map.get(cur) == 1) return i;
        }
        return -1;
    }

}
