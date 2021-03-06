/**
 * Given a non-negative integer c, your task is to decide whether
 * there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 *
 * Example 2:
 *
 * Input: 3
 * Output: False
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int temp = left * left + right * right;
            if (temp < c) {
                left += 1;
            } else if (temp > c) {
                right -= 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
