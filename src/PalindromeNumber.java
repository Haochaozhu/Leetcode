/**
 * Determine whether an integer is a palindrome. An integer is a
 * palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left,
 * it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int k = x;
        int n = 0;
        while (k != 0) {
            int digit = k % 10;
            k /= 10;
            if (n > Integer.MAX_VALUE || (n == Integer.MAX_VALUE && digit > Integer.MAX_VALUE % 10)) return false;
            n = n * 10 + digit;
        }
        return n == x;
    }

}
