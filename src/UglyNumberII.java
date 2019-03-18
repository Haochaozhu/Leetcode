/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.



ugly = 1, 2, 3, 4,
i2 = 2
i3 = 1
i5 = 1

 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i += 1) {
            ugly[i] = Math.min(2 * ugly[i2], Math.min(3 * ugly[i3], 5 * ugly[i5]));
            if (ugly[i] == ugly[i2] * 2) i2 += 1;
            if (ugly[i] == ugly[i3] * 3) i3 += 1;
            if (ugly[i] == ugly[i5] * 5) i5 += 1;
        }
        return ugly[n - 1];
    }

}
