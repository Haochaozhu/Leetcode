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
            int R = scan.nextInt();
            int C = scan.nextInt();
            scan.nextLine();
            String[] grid = new String[R];
            for (int i = 0; i < R; i += 1) {
                grid[i] = scan.nextLine();
            }
            System.out.println("Case #" + index + ": " + solve(grid));
            index += 1;
            testcases -= 1;
        }

    }

    private static int solve(String[] grid) {

        return 0;
    }
}
