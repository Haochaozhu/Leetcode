import java.util.HashMap;
import java.util.Map;

/**
 * Input: [30,20,150,100,40]
 *
 * 30 20 30 40 40
 * 2  1  2  2  2
 *
 * table[1] * table[59]
 *       2          58
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time) {
        int[] table = new int[60];
        for (int i : time) {
            table[i % 60] += 1;
        }
        int ans = 0;
        for (int i = 1; i < 30; i += 1) {
            ans += table[i] * table[60 - i];
        }
        ans += table[30] * (table[30] - 1) / 2;
        ans += table[0] * (table[0] - 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[]{30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(input));
    }
}
