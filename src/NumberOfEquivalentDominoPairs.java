import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int n = dominoes.length;
        Map<String, Integer> map = new HashMap<>();
        String cur = "";
        for (int i = 0; i < n; i++) {
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            cur = a + "," + b;
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                res += map.get(cur);
                map.put(cur, map.get(cur) + 1);
            }
        }
        return res;
    }
}
