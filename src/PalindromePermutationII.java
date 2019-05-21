import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 *
 * Example 1:
 *
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        int[] table = new int[256];
        for (char c : s.toCharArray()) {
            table[c]++;
        }
        int count = 0;
        String single = "";
        int length = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                if (table[i] % 2 != 0) {
                    count++;
                    single += (char)i;
                    table[i]--;
                }
                    table[i] /= 2;
                    length += table[i];
            }
        }
        if (count > 1) return ans;
        permute(ans, table,"", single + "", length);
        return ans;
    }

    private void permute(List<String> ans, int[] table, String cur, String mid, int length) {
        if (cur.length() == length) {
            StringBuilder sb = new StringBuilder(cur).reverse();
            ans.add(cur + mid + sb);
        } else {
            for (int i = 0; i < 256; i++) {
                if (table[i] > 0) {
                    table[i]--;
                    permute(ans, table, cur + (char)i, mid, length);
                    table[i]++;
                }
            }
        }
    }
} // aabcbaa
