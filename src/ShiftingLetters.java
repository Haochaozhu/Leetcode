/**
 * We have a string S of lowercase letters, and an integer array shifts.
 *
 * Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 *
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 *
 * Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
 *
 * Return the final string after all such shifts to S are applied.
 *
 * Example 1:
 *
 * Input: S = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation:
 * We start with "abc".
 * After shifting the first 1 letters of S by 3, we have "dbc".
 * After shifting the first 2 letters of S by 5, we have "igc".
 * After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 * Note:
 *
 * 1 <= S.length = shifts.length <= 20000
 * 0 <= shifts[i] <= 10 ^ 9
 */
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        int n = shifts.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + shifts[i];
            sum[i + 1] = sum[i + 1] % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shifts.length; i++) {
            char cur = (char)((S.charAt(i) - 'a' + sum[n] + 26 - sum[i]) % 26 + 'a');
            sb.append(cur);
        }
        // System.out.print();
        return sb.toString();
    }
}
