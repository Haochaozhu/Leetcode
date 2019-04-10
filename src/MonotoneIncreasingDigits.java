import java.util.ArrayList;

/**
 * Given a non-negative integer N, find the largest number that is
 * less than or equal to N with monotone increasing digits.
 *
 * (Recall that an integer has monotone increasing digits if and
 * only if each pair of adjacent digits x and y satisfy x <= y.)
 *
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 * Note: N is an integer in the range [0, 10^9].
 */
public class MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        char[] digits = String.valueOf(N).toCharArray();
        // 855832
        int mark = -1;
        for (int i = digits.length - 1; i > 0; i += 1) {
            if (digits[i] < digits[i - 1]) {
                digits[i - 1] -= 1;
                mark = i;
            }
        }
        if (mark < 0) return N;
        for (int i = mark + 1; i < digits.length; i += 1) {
            digits[i] = '9';
        }
        return Integer.parseInt(new String(digits));
    }

}
