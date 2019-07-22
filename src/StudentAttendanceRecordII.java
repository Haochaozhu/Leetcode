/**
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 *
 * A student attendance record is a string that only contains the following three characters:
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * Example 1:
 * Input: n = 2
 * Output: 8
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * Note: The value of n won't exceed 100,000.
 */
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        if (n == 0) return 0;
        if (n == 1) return 3;
        int mod = 1_000_000_007;
        long[] P = new long[n + 1];
        long[] L = new long[n + 1];
        long[] A = new long[n + 1];
        long[] AP = new long[n + 1];
        long[] AL = new long[n + 1];
        P[1] = 1;
        L[1] = 1;
        P[2] = 2;
        L[2] = 2;
        A[1] = AP[1] = AL[1] = 1;
        A[2] = 2;
        AP[2] = AL[2] = 3;

        for (int i = 3; i <= n; i++) {
            P[i] = L[i - 1] + P[i - 1];
            P[i] %= mod;
            L[i] = P[i - 1] + P[i - 2];
            L[i] %= mod;
            A[i] = P[i - 1] + L[i - 1];
            A[i] %= mod;
            AP[i] = A[i - 1] + AP[i - 1] + AL[i - 1];
            AP[i] %= mod;
            AL[i] = AP[i - 1] + A[i - 1] + AP[i - 2] + A[i - 2];
            AL[i] %= mod;
        }

        return (int)((A[n] + AP[n] + AL[n]) % mod);
    }
}
/**

 LL
 PL
 LLPL
 LLPL
 PLL

 **/