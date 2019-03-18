import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;
        int N = s.length();
        for (int a = 1; a < 4 && a < N - 2; a += 1) {
            for (int b = a + 1; b < a + 4 && b < N - 1; b += 1) {
                for (int c = b + 1; c < b + 4 && c < N; b += 1) {
                    String A  = s.substring(0, a);
                    String B = s.substring(a, b);
                    String C = s.substring(b, c);
                    String D = s.substring(c, N);
                    if (isValid(A) && isValid(B) && isValid(C) && isValid(D)) {
                            String str = A + "." + B + "." + C + "." + D;
                            ans.add(str);
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValid(String s) {
        if (s.length() == 1) return true;
        else return s.length() >= 1 && Integer.valueOf(s) <= 255 && s.charAt(0) != '0';
    }

}
