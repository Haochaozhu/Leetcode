import java.util.ArrayList;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int cur = 0;
        char sign = '+';
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i += 1) {
            if (Character.isDigit(s.charAt(i))) {
                cur = cur * 10 + s.charAt(i);
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (s.charAt(i) == '*') {
                    st.push(st.pop() * cur);
                }
                if (s.charAt(i) == '/') {
                    st.push(st.pop() / cur);
                }
                if (s.charAt(i) == '+') {
                    st.push(cur);
                }
                if (s.charAt(i) == '-') {
                    st.push(-cur);
                }
                cur = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}
