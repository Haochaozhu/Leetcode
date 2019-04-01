/**
 * Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
 *
 * The returned string must have no leading zeroes, unless the string is "0".
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: "110"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 * Example 2:
 *
 * Input: 3
 * Output: "111"
 * 11
 * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * Example 3:
 *
 * Input: 4
 * Output: "100"
 * Explantion: (-2) ^ 2 = 4
 *
 *
 * 11
 *
 */
public class ConvertToBaseNegative2 {
    public String baseNeg2(int N) {
        return null;
    }

    public static String base2(int N) {
        String res = "";
        System.out.println(N);
        int i = 1;
        while (N != 0) {
            res = (N & 1) + res;
            System.out.println(i + " res: " + res);
            N = -(N >> 1);
            System.out.println(i + " N: " + N);
            i += 1;
        }
        return res == ""  ? "0" : res;
    }


    public static void main(String[] args) {
        System.out.println(-1 >> 2);
    }
}
// 1011
// 0001