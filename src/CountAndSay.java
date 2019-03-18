import edu.princeton.cs.algs4.StdOut;

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
6.     312211
7.     13112221
8.     1113213211
9.     31131211131221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
1112
112
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i += 1) {
            res = next(res);
        }
        return res;
    }

    private String next(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += 1) {
            int count = 1;
            int j = i;
            while (j < s.length() - 1) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    j += 1;
                    count += 1;
                }
                else break;
            }
            sb.append(count);
            sb.append(s.charAt(i));
            i += count - 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay p = new CountAndSay();
        StdOut.println(p.countAndSay(1));
        StdOut.println(p.countAndSay(2));
        StdOut.println(p.countAndSay(3));
        StdOut.println(p.countAndSay(4));
        StdOut.println(p.countAndSay(9));

    }
}
