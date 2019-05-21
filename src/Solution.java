import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Input
 * The first line of the input gives the number of test cases, T.
 * T test cases follow. Each test case starts with a
 * line containing the two integers N and Q, the number of blocks and
 * the number of questions, respectively. Then, another line follows,
 * containing a string of N uppercase characters (A to Z). Then, Q lines follow.
 * The i-th line contains the two integers Li to Ri, describing the i-th question.
 *
 * Output
 * For each test case, output one line containing Case #x: y,
 * where x is the test case number (starting from 1) and y is the number of
 * questions Anna can answer "yes" to.
 *
 * Sample
 *
 * Input
 *
 * Output
 *
 * 2
 * 7 5
 * ABAACCA
 * 3 6
 * 4 4
 * 2 5
 * 6 7
 * 3 7
 * 3 5
 * XYZ
 * 1 3
 * 1 3
 * 1 3
 * 1 3
 * 1 3
 *
 *
 * Case #1: 3
 * Case #2: 0
 *
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        ans.add(new ArrayList<>(lst));
    }

}
