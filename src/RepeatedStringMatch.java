/**
 * Given two strings A and B, find the minimum number of times A has to
 * be repeated such that B is a substring of it. If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”),
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        if (A.indexOf(B) != -1) return 1;
        StringBuilder sb = new StringBuilder(A);
        int ans = 1;
        while (sb.length() < B.length()) {
            sb.append(A);
            ans++;
        }
        if (sb.indexOf(B) == -1) {
            sb.append(A);
            if (sb.indexOf(B) == -1) return -1;
            else return ans + 1;
        } else return ans;
    }

    public static void main(String[] args) {
        String A = "abcdabcdabcd";
        String B = "cdabcdab";
        System.out.println(A.indexOf(B));
    }
}
