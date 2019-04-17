import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this
 * string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i += 1) lastIndex[S.charAt(i) - 'a'] = i;
        int j = 0, anchor = 0;
        for (int i = 0; i < S.length(); i += 1) {
            j = Math.max(j, lastIndex[S.charAt(i)]);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor += 1;
            }
        }
        return ans;
    }
}
