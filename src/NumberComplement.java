/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits),
 * and its complement is 0. So you need to output 0.
 */
public class NumberComplement {
    /**
     * Solution by "hard coding".
     */
    public int findComplement(int num) {
         String input = Integer.toBinaryString(num);
         int ans = 0;
         char[] input_array = input.toCharArray();
         for (int i = 0; i < input_array.length; i += 1) {
            if (input_array[i] == '0') input_array[i] = '1';
            else input_array[i] = '0';
         }
         int base = 0;
         for (int i = input_array.length - 1; i >= 0; i -= 1) {
             ans += Character.getNumericValue(input_array[i]) * (int)Math.pow(2, base);
             base += 1;
         }
         return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0));
    }
}
