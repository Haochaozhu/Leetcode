/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.
 * Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) if (j != i) {
                for (int k = 0; k < 4; k++) if (k != j && k != i) {
                    int l = 6 - i - j - k;
                    int hours = 10 * A[i] + A[j];
                    int mins = 10 * A[k] + A[l];
                    if (hours < 24 && mins < 60) {
                        ans = Math.max(ans, hours * 60 + mins);
                    }
                }
            }
        }
        if (ans == -1) return "";
        return String.format("%2d:%2d", ans / 60, ans % 60);
    }
}
