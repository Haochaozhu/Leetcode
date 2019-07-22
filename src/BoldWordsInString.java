/**
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 *
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 *
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 *
 * Note:
 *
 * words has length in range [0, 50].
 * words[i] has length in range [1, 10].
 * S has length in range [0, 500].
 * All characters in words[i] and S are lowercase letters.
 */
public class BoldWordsInString {
    public String boldWords(String[] words, String S) {
        int n = S.length();
        boolean[] bold = new boolean[n];
        for (int i = 0; i < words.length; i++) {
            int cur = words[i].length();
            int idx = 0;
            while (S.indexOf(words[i], idx) != -1) {
                int from = S.indexOf(words[i], idx);
                int to = from + cur - 1;
                idx = from + 1;
                for (int j = from; j <= to; j++) {
                    bold[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if (bold[i] && (i == S.length() - 1 || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

}
