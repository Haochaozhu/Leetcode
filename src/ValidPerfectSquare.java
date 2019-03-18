/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

 */
public class ValidPerfectSquare {
    /**
     * Trivial approach based on definition. A square number is 1, 4, 9, 16, 25, 36...
     * That is 1 + 3 + 5 + 7 + 9 + 11 + ...
     * Time complexity: O(sqrt(n)). The inner loop will run sqrt(N) times.
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 1) return false;
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
         return num == 0;
    }

    /**
     * Binary Search.
     * Time complexityL O(log(N))
     */
    public boolean isPerfectSquare2(int num) {
        if (num < 1) return false;
        long low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    /**
     * Newton method
     */
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
