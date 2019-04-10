/**
 * Every non-negative integer N has a binary representation.
 * For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.
 * Note that except for N = 0, there are no leading zeroes in any binary representation.
 *
 * The complement of a binary representation is the number in binary you
 * get when changing every 1 to a 0 and 0 to a 1.
 * For example, the complement of "101" in binary is "010" in binary.
 *
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 *
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 *
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *
 *
 * Note:
 *
 * 0 <= N < 10^9
 */
public class ComplementOfBase10Integer {
    /**
     * Brute force.
     */
    public int bitwiseComplement(int N) {
        if(N == 0) return 1;
        String input = Integer.toBinaryString(N);
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

    /**
     * Bit manipulation.
     */
    public int bitwiseComplement2(int N) {
        if (N == 0) return 1;
        int h = Integer.highestOneBit(N);
        return N ^ (h * 2 - 1);
        /**
         * Key point: h * 2 stands for move the 1 bit to the left for 1 position, leaves 10000...
         * For example, for input 8, binary representation: 1000
         * highest one bit = 8,
         * 8 * 2 = 10000,
         * then minus 1:
         * 8 * 2 - 1 = 1111
         * 1000
         * ^
         * 1111
         * we get 0111 = 7
         */
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.highestOneBit(7));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.highestOneBit(8));
    }
/**

 8
 1000
 8
 1111
 0111x
 */
}
