import java.util.LinkedList;
import java.util.Queue;

/**
 * There are N dominoes in a line, and we place each domino vertically upright.
 *
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 *
 *
 *
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 *
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 *
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 *
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 *
 * Return a string representing the final state.
 *
 * Example 1:
 *
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * Example 2:
 *
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * Note:
 *
 * 0 <= N <= 10^5
 * String dominoes contains only 'L', 'R' and '.'
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        if (dominoes.isEmpty() || dominoes.length() == 1) return dominoes;
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int[] dp = new int[n];
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') force = n;
            else if (arr[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            dp[i] = force;
        }
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') force = n;
            else if (arr[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            dp[i] -= force;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (dp[i] > 0) sb.append('R');
            else if (dp[i] < 0) sb.append('L');
            else sb.append('.');
        }
        return sb.toString();
    }
}
