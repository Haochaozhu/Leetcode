import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 *
 *
 *
 * Example 1:
 *
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: "AAABBC"
 * Output: 188
 *
 *
 * Note:
 *
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        Set<String> set = new HashSet();
        backtrack(arr, new StringBuilder(), new boolean[tiles.length()], set);
        return set.size();
    }

    private void backtrack(char[] arr, StringBuilder sb, boolean[] visited, Set<String> set) {
        if (sb.length() > 0) set.add(sb.toString());
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(arr[i]);
            backtrack(arr, sb, visited, set);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
