import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.
 *
 * We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.
 *
 * We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.
 *
 * Return true if we can build the pyramid all the way to the top, otherwise false.
 *
 * Example 1:
 *
 * Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 *     A
 *    / \
 *   G   E
 *  / \ / \
 * B   C   D
 *
 * We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.
 *
 *
 * Example 2:
 *
 * Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 *
 *
 * Note:
 *
 * bottom will be a string with length in range [2, 8].
 * allowed will have length in range [0, 200].
 * Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class PyramidTransitionMatrix {
    Map<String, List<String>> map;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<>();
        for (String s : allowed) {
            String pre = s.substring(0, 2);
            map.putIfAbsent(pre, new ArrayList<>());
            map.get(pre).add(s.substring(2));
        }
        return check(bottom);
    }
    private boolean check(String bottom) {
        if (bottom.length() == 1) return true;
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2))) return false;
        }
        ArrayList<String> lst = new ArrayList<>();
        dfs(bottom, lst, 0, new StringBuilder());
        for (String s : lst) {
            if (check(s)) return true;
        }
        return false;
    }

    private void dfs(String bottom, ArrayList<String> lst, int idx, StringBuilder sb) {
        if (idx == bottom.length() - 1) {
            lst.add(sb.toString());
            return;
        }
        String temp = bottom.substring(idx, idx + 2);
        for (String str : map.get(temp)) {
            sb.append(str);
            dfs(bottom, lst, idx + 1, sb);
        }
    }
}
