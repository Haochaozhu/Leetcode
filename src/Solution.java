import java.util.Scanner;

/**
 * Input
 *
 * Output
 *
 * 3
 * 4 3
 * 3 1 9 100    Case #1: 14
 * 1 3 9 100
 * 6 2
 * 5 5 1 2 3 4  Case #2: 0
 * 5 5
 * 7 7 1 7 7    Case #3: 6
 *
 *
 * Case #1: 14
 * Case #2: 0
 * Case #3: 6
 *
 *
 * "Case #" + index + ": " + solve(grid)
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        scan.nextLine();
        int index = 1;
        while (testcases > 0) {
            int N = scan.nextInt();
            scan.nextLine();
            int[] res = solve(N);
            int a = res[0];
            int b = res[1];
            System.out.println("Case #" + index + ": " + a + " " + b);
            index += 1;
            testcases -= 1;
        }

    }
    private static int[] solve(int N) {
        for (int i = 1; i <= N / 2; i += 1) {
            if (!hasFour(i) && !hasFour(N - i)) return new int[]{i, N - i};
        }
        return null;
    }

    private static boolean hasFour(int n) {
        while (n != 0) {
            if (n % 10 == 4) return true;
            n /= 10;
        }
        return false;
    }
}
