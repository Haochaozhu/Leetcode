/**
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function
 * like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i += 1) {
            if ((i & 1) == 0) ans[i] = ans[i >> 2];
            else ans[i] = ans[i - 1] + 1;
        }
        return ans;
    }
}
/**
 * 0       0
 * 1    0001
 * 2    0010
 * 3    0011
 * 4    0100
 * 5    0101
 * 6    0110
 * 7    0111
 * 8    1000
 * 9    1001
 * 10   1010
 * 11   1011
 * 12   1100
 * 13   1101
 * 14   1110
 * 15   1111
 * 16  10000
 */
