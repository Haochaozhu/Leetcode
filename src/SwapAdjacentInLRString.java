/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 * Example:
 *
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Note:
 *
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
        int i = 0, j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i == start.length() && j == end.length()) return true;
            if (i == start.length() || j == end.length()) return false;
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
