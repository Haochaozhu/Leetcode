/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j += 1) {
            char c = s.charAt(i);
            if (map.containsKey(c)) i = Math.max(i, map.get(c) + 1);
            map.put(c, j);
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] index = new int[126];
        StdOut.println(index['c']);
    }
}
