import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 *
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 *
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 *
 * Output: "45"
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        Map<Integer, String> map = new HashMap<>();
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i <= 9; i++) {
            map.put(i, str[i]);
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        String ans = "";
        for (int i = 0; i <= 9; i++) {
            while (canBuild(map.get(i), count)) {
                for (char c : map.get(i).toCharArray()) {
                    count.put(c, count.get(c) - 1);
                }
                ans += i;
            }
        }
        return ans;
    }

    private boolean canBuild(String s, Map<Character, Integer> count) {
        int i = 0;
        while (i < s.length()) {
            if (count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) > 0) {
                i++;
            } else {
                break;
            }
        }
        return i == s.length();
    }
}
