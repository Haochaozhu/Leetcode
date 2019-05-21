import java.util.*;

/**
 * S and T are strings composed of lowercase letters.
 * In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously. We want to permute the characters of T
 * so that they match the order that S was sorted.
 * More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 *
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda"
 * are also valid outputs.
 *
 *
 * Note:
 *
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        Character[] ans = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            ans[i] = T.charAt(i);
        }
        Arrays.sort(ans, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (S.indexOf(c1) < S.indexOf(c2)) return -1;
                else if (S.indexOf(c1) == S.indexOf(c2)) return 0;
                else return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : ans) sb.append(c);
        return sb.toString();
    }
}
