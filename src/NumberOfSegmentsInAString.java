/**
 * Count the number of segments in a string, where a segment
 * is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int ans = 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == ' ') ans += 1;
        }
        return ans + 1;
    }
}
