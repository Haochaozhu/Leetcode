/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T
 * (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 *
 * Note:
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int l = Math.min(m, n);
        String ans = "";
        for (int i = 1; i <= l; i++) {
            String cur1 = str1.substring(0, i);
            String cur2 = str2.substring(0, i);
            if (!cur1.equals(cur2)) return "";
            if (m % cur1.length() != 0 || n % cur2.length() != 0) continue;
            int p = m / cur1.length() - 1;
            int q = n / cur2.length() - 1;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < p; j++) {
                sb1.append(cur1);
            }
            for (int j = 0; j < q; j++) {
                sb2.append(cur2);
            }
            if (str1.indexOf(sb1.toString()) != -1 && str2.indexOf(sb2.toString()) != -1) ans = cur1;
        }
        return ans;
    }

}
