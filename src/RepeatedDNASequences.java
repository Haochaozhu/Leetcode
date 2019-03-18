import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequences {
    /**
     * Brute force approach
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() <= 10) return ans;
        HashSet<String> set = new HashSet<>();
        HashSet<String> set_ans = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i += 1) {
            String cur = s.substring(i, i + 10);
            if (!set.add(cur)) {
                set_ans.add(cur);
            }
        }
        ans.addAll(set_ans);
        return ans;
    }

}
