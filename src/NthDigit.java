/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.q
 *
 *
 * 1 2 3 4 5 6 7 8 9 1 0 1 1 1 2 1 3 1 4 1 5 1 6 1 7 1 8 1 9 2 0 2 1 2 2 2 3 2 4 2 5 2 6
 */
public class NthDigit {
    /**
     * Brute force
     */
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int base = 1;
        while (n > 9 * Math.pow(10, base - 1) * base) {
            n = n - 9 * (int)Math.pow(10, base - 1) * base;
            base += 1;
        }
        int num = (int)Math.pow(10, base - 1) + (n - 1) / base;
        int index = (n - 1) % base;
        return Integer.toString(num).charAt(index) - '0';
    }
}
